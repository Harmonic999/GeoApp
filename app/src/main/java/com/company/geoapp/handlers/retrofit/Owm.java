package com.company.geoapp.handlers.retrofit;

import com.company.geoapp.handlers.Logger;
import com.company.geoapp.model.weather.WeatherModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Owm {

    private static final String API_BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final OwmClient client;

    private static OnResponseSuccessListener<WeatherModel> listener;

    static {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        client = retrofit.create(OwmClient.class);
    }

    @SuppressWarnings("all")
    public static void tryLoadWeatherForDefinedCity(String cityName) {
        Call<WeatherModel> call = client.getWeather(cityName);

        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if (listener != null) Owm.listener.handleSuccessfulResponse(response);
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                Logger.infoLog("no response");
            }
        });
    }

    public static void registerListener(OnResponseSuccessListener<WeatherModel> listener) {
        Owm.listener = listener;
    }

}
