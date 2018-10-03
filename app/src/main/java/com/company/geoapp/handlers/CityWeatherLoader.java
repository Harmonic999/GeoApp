package com.company.geoapp.handlers;

import java.io.IOException;

public interface CityWeatherLoader {

    String getCityWeather(String cityName) throws IOException;
}
