package com.company.geoapp.interfaces;

import com.hannesdorfmann.mosby.mvp.MvpView;

public interface CityWeatherView extends MvpView {

    void showWeatherInfo(String location,
                         String description,
                         double temperature,
                         long sunrise,
                         long sunset);

}
