package com.ron.weatherlib;

import android.util.Log;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherProvided {
    public interface getWeather{
        void weather(WeatherResult weatherResult);
        void failed(String msg);
    }
    private static WeatherProvided weatherProvided = new WeatherProvided();
    private Retrofit retrofit;
    private getWeather weatherCallback;
    private WeatherApi weatherApi;

    private WeatherProvided() {
        initializeRetrofit();

    }

    public WeatherProvided setWeatherCallback(getWeather weatherCallback) {
        this.weatherCallback = weatherCallback;
        return this;
    }

    private void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.weatherapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        weatherApi= retrofit.create(WeatherApi.class);
    }

    public  static WeatherProvided getInstance(){
        return weatherProvided;
    }

    public boolean execWeatherRequest(String city) {
        if (weatherCallback == null)
            return false;
        weatherApi.getWeather("c0b1393d087b42e9a5c114643232306",city).enqueue(getWeatherSelfCallback);
        return true;
    }

    private Callback<WeatherResult> getWeatherSelfCallback = new Callback<WeatherResult>() {
        @Override
        public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
            Log.d("myLog", response.code() + "");
            if(response.code() == 200){
                if (response.body() == null){
                    Log.d("MyLog", "Get Weather null");
                    weatherCallback.failed(response.code() + "failed - Wrong details");
                    return;
                }
                Log.d("myLog", "Get weather OK"+response.body().toString());
                weatherCallback.weather(response.body());
            }
            else if(response.code() >=  400){
                Log.d("myLog", "Get weather not ok");
                weatherCallback.failed(response.code() + " failed - Wrong details");
            }
        }
        @Override
        public void onFailure(Call<WeatherResult> call, Throwable t) {
            Log.d("myLog", "Get Weather failed -1 "+t.getMessage());
            weatherCallback.failed(t.getMessage());
        }
    };
}
