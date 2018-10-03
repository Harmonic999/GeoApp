package com.company.geoapp;

import com.company.geoapp.model.Weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherTestData {

    public static final Weather WEATHER_1;
    public static final Weather WEATHER_2;
    public static final Weather WEATHER_3;
    public static final Weather WEATHER_4;

    public static final List<Weather> testWeatherList;

    static {
        WEATHER_1 = new Weather("Kiev", "broken clouds", 12.5);
        WEATHER_2 = new Weather("Kharkiv", "broken clouds", 14.1);
        WEATHER_3 = new Weather("London", "broken clouds", 17.3);
        WEATHER_4 = new Weather("Moscow", "broken clouds", 9.4);

        testWeatherList = new ArrayList<>();
        testWeatherList.add(WEATHER_1);
        testWeatherList.add(WEATHER_2);
        testWeatherList.add(WEATHER_3);
        testWeatherList.add(WEATHER_4);
    }

    public static void compareWeather(Weather actual, Weather expected) {

    }

    public static void compareWeatherList() {

    }


}
