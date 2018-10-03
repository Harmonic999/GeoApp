package com.company.geoapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.text.DecimalFormat;

@Entity
public class Weather implements Comparable<Weather> {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "location")
    private String location; // City name

    @ColumnInfo(name = "generalDescription")
    private String generalDescription;  //example scattered clouds

    @ColumnInfo(name = "temperature")
    private Double temperature;

    public Weather() {
    }

    public Weather(String location, String generalDescription, double temperature) {
        this.location = location;
        this.generalDescription = generalDescription;
        this.temperature = temperature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @NonNull
    @Override
    public String toString() {
        DecimalFormat df2 = new DecimalFormat(".#");
        return "Weather{" +
                "location='" + location + '\'' +
                ", generalDescription='" + generalDescription + '\'' +
                ", temperature=" + df2.format(temperature) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather = (Weather) o;

        if (!location.equals(weather.location)) return false;
        if (!generalDescription.equals(weather.generalDescription)) return false;
        return temperature.equals(weather.temperature);
    }

    @Override
    public int hashCode() {
        int result = location.hashCode();
        result = 31 * result + generalDescription.hashCode();
        result = 31 * result + temperature.hashCode();
        return result;
    }

    @Override
    public int compareTo(@NonNull Weather o) {
        return this.location.compareTo(o.location);
    }
}
