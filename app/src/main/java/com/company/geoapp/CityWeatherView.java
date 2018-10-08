package com.company.geoapp;

import com.hannesdorfmann.mosby.mvp.MvpView;

public interface CityWeatherView extends MvpView {

    void showWeatherInfo(String location, String description, String temperature);

}
