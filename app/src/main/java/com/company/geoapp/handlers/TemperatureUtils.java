package com.company.geoapp.handlers;

import java.text.DecimalFormat;

public class TemperatureUtils {

    private TemperatureUtils() {
    }

    public static double kelvinToCelsius(double kelvinDegrees) {
        return kelvinDegrees - 273.15;
    }

    public static String temperatureAsString(double degrees) {
        DecimalFormat df = new DecimalFormat(".#");
        return df.format(degrees) + "\u00b0"; //character for Celsius degree
    }

}
