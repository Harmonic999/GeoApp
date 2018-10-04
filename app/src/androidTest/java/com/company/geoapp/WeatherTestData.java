package com.company.geoapp;

import com.company.geoapp.dao.WeatherDbRepr;

public class WeatherTestData {

    public static final WeatherDbRepr WEATHER_1;
    public static final WeatherDbRepr WEATHER_2;
    public static final WeatherDbRepr WEATHER_3;


    static {

        WEATHER_1 = new WeatherDbRepr("London", "{\n" +
                "    \"coord\": {\n" +
                "        \"lon\": 30.52,\n" +
                "        \"lat\": 50.43\n" +
                "    },\n" +
                "    \"weather\": [\n" +
                "        {\n" +
                "            \"id\": 802,\n" +
                "            \"main\": \"Clouds\",\n" +
                "            \"description\": \"scattered clouds\",\n" +
                "            \"icon\": \"03d\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"base\": \"stations\",\n" +
                "    \"main\": {\n" +
                "        \"temp\": 284.15,\n" +
                "        \"pressure\": 1016,\n" +
                "        \"humidity\": 53,\n" +
                "        \"temp_min\": 284.15,\n" +
                "        \"temp_max\": 284.15\n" +
                "    },\n" +
                "    \"visibility\": 10000,\n" +
                "    \"wind\": {\n" +
                "        \"speed\": 7,\n" +
                "        \"deg\": 290,\n" +
                "        \"gust\": 12\n" +
                "    },\n" +
                "    \"clouds\": {\n" +
                "        \"all\": 40\n" +
                "    },\n" +
                "    \"dt\": 1538658000,\n" +
                "    \"sys\": {\n" +
                "        \"type\": 1,\n" +
                "        \"id\": 7348,\n" +
                "        \"message\": 0.0023,\n" +
                "        \"country\": \"UA\",\n" +
                "        \"sunrise\": 1538625798,\n" +
                "        \"sunset\": 1538666929\n" +
                "    },\n" +
                "    \"id\": 703448,\n" +
                "    \"name\": \"London\",\n" +
                "    \"cod\": 200\n" +
                "}");

        WEATHER_2 = new WeatherDbRepr("Paris", "mock");
        WEATHER_3 = new WeatherDbRepr("Kharkiv", "mock");
    }
}
