package com.company.geoapp;

import com.company.geoapp.handlers.OwmWeatherLoader;
import com.company.geoapp.handlers.WeatherInfoLoader;
import com.company.geoapp.model.weather.Weather;

import org.junit.Test;

import java.io.IOException;

public class WeatherInfoLoaderTest {

    @Test
    public void JsonLoader() throws IOException {
        WeatherInfoLoader loader = new OwmWeatherLoader();
        Weather londonWeather = loader.getWeatherForDefinedCity("London");
        Weather kievWeather = loader.getWeatherForDefinedCity("Kiev");
        Weather kharkivWeather = loader.getWeatherForDefinedCity("Kharkiv");
        Weather moscowWeather = loader.getWeatherForDefinedCity("Moscow");
        Weather parisWeather = loader.getWeatherForDefinedCity("Paris");

        System.out.println(londonWeather);
        System.out.println(kievWeather);
        System.out.println(kharkivWeather);
        System.out.println(moscowWeather);
        System.out.println(parisWeather);

    }
}