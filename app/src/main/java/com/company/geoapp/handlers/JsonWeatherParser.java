package com.company.geoapp.handlers;

import com.company.geoapp.model.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JsonWeatherParser {

    private JsonWeatherParser() {
    }

    static Weather parseJsonResponseToObj(String responseJsonObj) {
        Weather w = null;
        try {
            JSONObject obj = new JSONObject(responseJsonObj);
            String location = getLocation(obj);
            String generalDescription = getGeneralDescription(obj);
            double temperature = getTemperature(obj);
            w = new Weather(location, generalDescription, temperature);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return w;
    }

    private static String getLocation(JSONObject obj) {
        return obj.optString("name");
    }

    private static String getGeneralDescription(JSONObject obj) throws JSONException {
        JSONArray array = obj.getJSONArray("weather");
        JSONObject weather = array.getJSONObject(0);
        return weather.optString("description");
    }

    private static double getTemperature(JSONObject obj) throws JSONException {
        JSONObject main = obj.getJSONObject("main");
        double kelvinTemp = main.getDouble("temp");
        return kelvinTemp - 273; //перевод в градусы Цельсия
    }
}
