package com.company.geoapp;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.company.geoapp.dao.AppDatabase;
import com.company.geoapp.dao.WeatherDao;
import com.company.geoapp.dao.WeatherDbRepr;
import com.company.geoapp.handlers.JsonHandler;
import com.company.geoapp.handlers.Logger;
import com.company.geoapp.handlers.retrofit.OnResponseSuccessListener;
import com.company.geoapp.handlers.retrofit.Owm;
import com.company.geoapp.model.weather.WeatherModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import retrofit2.Response;

import static com.company.geoapp.WeatherTestData.*;

@RunWith(AndroidJUnit4.class)
public class WeatherDatabaseTest {

    private WeatherDao weatherDao;

    @Before
    public void prepare() {
        initDb();
        registerListenerForOpenWeatherMapClient();
        populateDb();
    }

    @Test
    public void insertTest() {
        Owm.tryLoadWeatherForDefinedCity("Kiev");
    }

    @Test
    public void insertDuplicateTest() {
        Owm.tryLoadWeatherForDefinedCity("London");
    }

    @Test
    public void deleteByLocationTest() {
        weatherDao.deleteByLocation("London");
    }

    @Test
    public void getWeatherModelFromDb() {
        WeatherDbRepr w = weatherDao.getByLocation(WEATHER_1.getLocation());
        WeatherModel weather = JsonHandler.parseFromJson(w.getJson_weather(), WeatherModel.class);
        Logger.infoLog(weather.toString());
    }

    @SuppressWarnings("all")
    private void handleResponse(Response<WeatherModel> response) {
        WeatherModel weather = response.body();
        WeatherDbRepr weatherDbRepr = new WeatherDbRepr(weather.name, JsonHandler.parseToJson(weather));

        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                weatherDao.insert(weatherDbRepr);
                return weatherDbRepr.getLocation();
            }
        }.execute();
    }

    private void initDb() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        AppDatabase db = Room.inMemoryDatabaseBuilder(appContext, AppDatabase.class).build();
        weatherDao = db.weatherDao();
    }

    private void registerListenerForOpenWeatherMapClient() {
        OnResponseSuccessListener<WeatherModel> listener = WeatherDatabaseTest.this::handleResponse;
        Owm.registerListener(listener);
    }

    private void populateDb() {
        weatherDao.insert(WEATHER_1);
        weatherDao.insert(WEATHER_2);
        weatherDao.insert(WEATHER_3);
    }
}
