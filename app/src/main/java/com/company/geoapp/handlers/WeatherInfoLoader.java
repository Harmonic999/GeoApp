package com.company.geoapp.handlers;

import com.company.geoapp.model.weather.Weather;

import java.io.IOException;

public interface WeatherInfoLoader {

    Weather getWeatherForDefinedCity(String cityName) throws IOException;
}
