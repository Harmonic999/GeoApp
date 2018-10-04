package com.company.geoapp.delete;

import java.io.IOException;

public interface WeatherInfoLoader {

    Weather getWeatherForDefinedCity(String cityName) throws IOException;

}
