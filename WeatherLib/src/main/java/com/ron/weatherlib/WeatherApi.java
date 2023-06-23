package com.ron.weatherlib;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("current.json")
    Call<WeatherResult> getWeather(@Query("key") String key, @Query("q") String cityName );
}
