package com.company.geoapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpFragment;

public class WeatherFragment extends MvpFragment<CityWeatherView, CityWeatherPresenter> implements CityWeatherView {

    private TextView locationTxt;
    private TextView descriptionTxt;
    private TextView temperatureTxt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        String cityName = this.getArguments().getString("cityName");
        presenter.loadWeatherDetails(cityName);
    }

    @NonNull
    @Override
    public CityWeatherPresenter createPresenter() {
        return new CityWeatherPresenter(getContext());
    }

    @Override
    public void showWeatherInfo(String location, String description, double temperature) {
        locationTxt.setText(location);
        descriptionTxt.setText(description);
        temperatureTxt.setText(String.valueOf(temperature));
    }

    private void initViews(View view) {
        locationTxt = view.findViewById(R.id.locationTextView);
        descriptionTxt = view.findViewById(R.id.descriptionTextView);
        temperatureTxt = view.findViewById(R.id.temperatureTextView);
    }
}