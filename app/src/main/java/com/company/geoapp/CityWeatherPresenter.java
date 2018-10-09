package com.company.geoapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.company.geoapp.dao.AppDatabase;
import com.company.geoapp.dao.WeatherDao;
import com.company.geoapp.dao.WeatherDbRepr;
import com.company.geoapp.handlers.JsonHandler;
import com.company.geoapp.handlers.Logger;
import com.company.geoapp.handlers.retrofit.OnResponseSuccessListener;
import com.company.geoapp.handlers.retrofit.Owm;
import com.company.geoapp.model.weather.WeatherModel;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import retrofit2.Response;

public class CityWeatherPresenter extends MvpBasePresenter<CityWeatherView> implements OnResponseSuccessListener<WeatherModel> {

    private Context context;

    public CityWeatherPresenter(Context context) {
        this.context = context;
        Owm.registerListener(this);
    }

    public void loadWeatherDetails(String cityName) {
        Owm.tryLoadWeatherForDefinedCity(cityName);
    }

    @Override
    public void handleSuccessfulResponse(Response<WeatherModel> response) {
        WeatherModel model = response.body();
        new SaveToDbAndPassToViewTask(model).execute();
    }

    private class SaveToDbAndPassToViewTask extends AsyncTask<Void, Void, WeatherModel> {

        final WeatherModel model;

        SaveToDbAndPassToViewTask(WeatherModel model) {
            this.model = model;
        }

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(context,
                    "Loading data from web",
                    "wait...",
                    true);
        }

        @Override
        protected WeatherModel doInBackground(Void... voids) {
            WeatherDao dao = AppDatabase
                    .getInstance(context)
                    .weatherDao();
            Logger.infoLog("saving weather info to database");
            dao.insert(convertToDbRepresentation(model));
            dao.getByLocation(model.name);
            return convertFromDbRepresentation(dao.getByLocation(model.name));
        }

        @Override
        protected void onPostExecute(WeatherModel model) {
            passToView(model);
            progressDialog.dismiss();
        }
    }

    private void passToView(WeatherModel model) {
        if (isViewAttached()) {
            Logger.infoLog("transferring model to view");
            getView().showWeatherInfo(model.name,
                    model.weather.get(0).description,
                    model.main.temp,
                    model.sys.sunrise,
                    model.sys.sunset);
        }
    }

    private WeatherDbRepr convertToDbRepresentation(WeatherModel model) {
        return new WeatherDbRepr(model.name, JsonHandler.parseToJson(model));
    }

    private WeatherModel convertFromDbRepresentation(WeatherDbRepr databaseModel) {
        return JsonHandler.parseFromJson(databaseModel.getJson_weather(), WeatherModel.class);
    }
}
