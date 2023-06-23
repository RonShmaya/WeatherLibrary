package com.ron.weatherlibary;

import java.util.HashMap;
import java.util.Map;

public class WeatherRequestDet {
    public static final String HUMIDITY = "HUMIDITY";
    public static final String PRECIPITATION = "PRECIPITATION";
    public static final String WIND_SPEED = "WIND_SPEED";
    public static final String PRESSURE = "PRESSURE";
    public static final String COUNTRY = "COUNTRY";
    public static final String TEMPERATURE_C = "TEMPERATURE_C";
    public static final String TEMPERATURE_F = "TEMPERATURE_F";
    public static final String FEELS_C = "FEELS_C";
    public static final String FEELS_F = "FEELS_F";

    private String city;
    private Map<String, Boolean> propertiesToShow = new HashMap<>();

    public WeatherRequestDet(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public WeatherRequestDet setCity(String city) {
        this.city = city;
        return this;
    }

    public WeatherRequestDet addProperty(String property, boolean toShow) {
        propertiesToShow.put(property, toShow);
        return this;
    }
    public boolean isNeedToShow(String property) {
        return propertiesToShow.get(property);
    }
}
