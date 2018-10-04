package com.company.geoapp.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.company.geoapp.model.weather.Weather;

import java.util.List;

@Dao
public interface WeatherDao {

    @Query("SELECT * FROM weather ORDER BY location ASC")
    List<Weather> getAll();

    @Query("SELECT * FROM weather WHERE location LIKE :location LIMIT 1")
    Weather getByLocation(String location);

    @Insert
    void insert(Weather weather);

    @Update
    void update(Weather weather);

    @Delete
    void delete(Weather weather);

    @Delete
    void deleteAll(Weather... weathers);

}
