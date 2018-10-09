package com.company.geoapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.company.geoapp.interfaces.CityWeatherView;
import com.company.geoapp.R;
import com.company.geoapp.presenters.CityWeatherPresenter;
import com.hannesdorfmann.mosby.mvp.MvpFragment;

import static com.company.geoapp.handlers.TemperatureUtils.*;

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
    public void showWeatherInfo(String location, String description, double temperature, long sunrise, long sunset) {
        //Logger.infoLog("sunrise=" + getStringDateFromUnixTimestamp(sunrise));
        //Logger.infoLog("sunset=" + getStringDateFromUnixTimestamp(sunset));

        locationTxt.setText(location);

        descriptionTxt.setText(description.substring(0, 1).toUpperCase() + description.substring(1)); //first letter to Upper Case

        temperatureTxt.setText(temperatureAsString(kelvinToCelsius(temperature))); // kelvin to celsius
    }

    private void initViews(View view) {
        locationTxt = view.findViewById(R.id.locationTextView);
        descriptionTxt = view.findViewById(R.id.descriptionTextView);
        temperatureTxt = view.findViewById(R.id.temperatureTextView);
    }
}