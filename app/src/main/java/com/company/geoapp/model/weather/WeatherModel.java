package com.company.geoapp.model.weather;

import java.util.List;

public class WeatherModel {

    public Coordinate coord;
    public List<WeatherDescription> weather;
    public String base;
    public WeatherCondition main;
    public int visibility;
    public Wind wind;
    public Cloud clouds;
    public long dt;
    public Sys sys;
    public int id;
    public String name;
    public int cod;

    @Override
    public String toString() {
        return "WeatherModel{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}
