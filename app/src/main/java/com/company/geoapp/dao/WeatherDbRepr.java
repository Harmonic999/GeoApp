package com.company.geoapp.dao;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "weathers")
public class WeatherDbRepr {

    @PrimaryKey
    @ColumnInfo(name = "location")
    @NonNull
    private final String location;

    @ColumnInfo(name = "json_weather")
    private final String json_weather;

    public WeatherDbRepr(@NonNull String location, String json_weather) {
        this.location = location;
        this.json_weather = json_weather;
    }

    @NonNull
    public String getLocation() {
        return location;
    }

    public String getJson_weather() {
        return json_weather;
    }

}
