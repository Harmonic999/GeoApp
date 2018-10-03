package com.company.geoapp.model;

public class CityWeather {

    private final String cityName;
    private final String generalDescription;  //example scattered clouds
    private final float temperature;

    public CityWeather(String cityName, String generalDescription, float temperature) {
        this.cityName = cityName;
        this.generalDescription = generalDescription;
        this.temperature = temperature;
    }

    public String getCityName() {
        return cityName;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public float getTemperature() {
        return temperature;
    }
}
