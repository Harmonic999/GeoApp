package com.company.geoapp;

import android.support.test.runner.AndroidJUnit4;

import com.company.geoapp.handlers.retrofit.Owm;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class WeatherLoaderTest {

    @Test
    public void loadParseTest() {
        Owm.tryLoadWeatherForDefinedCity("London");
    }

}