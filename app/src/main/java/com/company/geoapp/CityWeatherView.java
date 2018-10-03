package com.company.geoapp;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

public interface CityWeatherView extends MvpLceView<String> {

    void showCurrentWeather();

}
