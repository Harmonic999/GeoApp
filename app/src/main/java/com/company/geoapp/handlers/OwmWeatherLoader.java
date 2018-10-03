package com.company.geoapp.handlers;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class OwmWeatherLoader implements CityWeatherLoader {

    public static void main(String[] args) throws IOException, JSONException {
        CityWeatherLoader loader = new OwmWeatherLoader();
        String jsonString = loader.getCityWeather("Kiev");
        System.out.println(jsonString);

        //JSONObject obj = new JSONObject("{\"name\" : \"John\"}");
        //String weatherDescription = obj.getJSONObject("weather").getString("description");
        //System.out.println(weatherDescription);
    }

    private OpenWeatherMapService service;

    public String getCityWeather(String cityName) throws IOException {
        if (service == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            service = retrofit.create(OpenWeatherMapService.class);
        }
        return service.getStringCityWeather(cityName).execute().body();
    }

    private static final String KEY = "uk&APPID=ed44bb979a766f130b431e3cd2f190c6";

    private interface OpenWeatherMapService {

        @GET("weather?" + KEY)
        Call<String> getStringCityWeather(@Query("q") String cityName);
    }
}
