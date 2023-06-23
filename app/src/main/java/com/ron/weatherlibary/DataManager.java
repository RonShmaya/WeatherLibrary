package com.ron.weatherlibary;

public class DataManager {
    private static DataManager _instance = new DataManager();
    private WeatherRequestDet weatherRequestDet;


    private DataManager() {
    }

    public WeatherRequestDet getWeatherRequestDet() {
        return weatherRequestDet;
    }

    public DataManager setWeatherRequestDet(WeatherRequestDet weatherRequestDet) {
        this.weatherRequestDet = weatherRequestDet;
        return this;
    }

    public static DataManager getDataManager() {
        return _instance;
    }

}
