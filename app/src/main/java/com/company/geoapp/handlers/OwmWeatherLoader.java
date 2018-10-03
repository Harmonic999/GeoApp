package com.company.geoapp.handlers;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class OwmWeatherLoader implements CityWeatherLoader {

    public static void main(String[] args) throws IOException {
        CityWeatherLoader loader = new OwmWeatherLoader();
        System.out.println(loader.getCityWeather("Kiev"));
    }

    private OpenWeatherMapService service;

    public String getCityWeather(String cityName) throws IOException {
        if (service == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("api.openweathermap.org/data/2.5/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            service = retrofit.create(OpenWeatherMapService.class);
        }
        return service.getStringCityWeather(cityName).execute().body();
    }

    private static final String KEY = "uk&APPID=ed44bb979a766f130b431e3cd2f190c6";

    private interface OpenWeatherMapService {

        @GET("weather?q={cityName}," + KEY)
        Call<String> getStringCityWeather(@Path("city") String cityName);
    }
}
