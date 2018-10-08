package com.company.geoapp.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WeatherDao {

    @Query("SELECT * FROM weathers")
    List<WeatherDbRepr> getAll();

    @Query("SELECT * FROM weathers WHERE location LIKE :location LIMIT 1")
    WeatherDbRepr getByLocation(String location);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(WeatherDbRepr weather);

    @Query("DELETE FROM weathers WHERE location LIKE :location")
    void deleteByLocation(String location);

}
