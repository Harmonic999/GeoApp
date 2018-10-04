package com.company.geoapp.handlers;

import com.company.geoapp.model.weather.Weather;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class OwmWeatherLoader implements WeatherInfoLoader {

    private static final String KEY = "uk&APPID=ed44bb979a766f130b431e3cd2f190c6"; //ключ для авторизации на сервисе

    private final OpenWeatherMapService service;

    private interface OpenWeatherMapService {

        @GET("weather?" + KEY)
        Call<String> getStringCityWeather(@Query("q") String cityName);
    }

    public OwmWeatherLoader() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        service = retrofit.create(OpenWeatherMapService.class);
    }

    @Override
    public Weather getWeatherForDefinedCity(String cityName) throws IOException {
        String responseJsonObj = service.getStringCityWeather(cityName).execute().body();
        return JsonWeatherParser.parseJsonResponseToObj(responseJsonObj);
    }

}
