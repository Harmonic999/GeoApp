package com.company.geoapp;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.company.geoapp.dao.AppDatabase;
import com.company.geoapp.dao.WeatherDao;
import com.company.geoapp.model.Weather;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.List;

import static com.company.geoapp.WeatherTestData.*;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class WeatherDatabaseTest {

    private WeatherDao weatherDao;

    @Before
    public void initInMemoryDb() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        AppDatabase db = Room.inMemoryDatabaseBuilder(appContext, AppDatabase.class).build();
        weatherDao = db.weatherDao();
        weatherDao.insert(WEATHER_1);
        weatherDao.insert(WEATHER_2);
        weatherDao.insert(WEATHER_3);
    }

    @Test
    public void insertTest() {
        weatherDao.insert(WEATHER_4);

    }

    @Test
    public void getWeatherByLocationTest() {


        weatherDao.insert(WEATHER_1);

    }

}
