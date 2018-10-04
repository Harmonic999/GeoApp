package com.company.geoapp.handlers.retrofit;

import com.company.geoapp.model.weather.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface OwmClient {

    String KEY = "uk&APPID=ed44bb979a766f130b431e3cd2f190c6"; //ключ для авторизации на сервисе

    @GET("weather?" + KEY)
    Call<WeatherModel> getWeather(@Query("q") String cityName);
}