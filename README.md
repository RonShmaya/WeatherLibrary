# WeatherLibrary
[![](https://jitpack.io/v/RonShmaya/WeatherLibrary.svg)](https://jitpack.io/#RonShmaya/WeatherLibrary)

Library for getting all weather properties in an easy way by city name.
The Library Uses Retrofit for getting the data from https://www.weatherapi.com/api

## Example
|Select|Result|
|---|---|
|<img src="https://github.com/RonShmaya/Attributes/blob/main/weather_main.jpg" height="650" width="300" />|<img src="https://github.com/RonShmaya/Attributes/blob/main/weather_result.jpg" height="650" width="300"/>|

## Video
<img src="https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExaDF1ams0bzVhMmY4cGV1cTVsb3N5Z3FjeTBvc2RrbjBmbG13a3FjOCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/gswS1iTsMQc8tXA2d8/giphy.gif" alt="animated"/>


## Setup
Step 1. Add it to your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
	maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency:

```
dependencies {
  implementation 'com.github.RonShmaya:WeatherLibrary:1.00.00'
}
```
## Usage

###### Create A Request - set callback & city name:
```java
        WeatherProvided.getInstance().setWeatherCallback(weatherCallBack)
                .execWeatherRequest({cityName});

```
###### The Callback  A Callback:
```java
    public interface getWeather{
        void weather(WeatherResult weatherResult);
        void failed(String msg);
  

```
###### Callback Example:
```java
    private WeatherProvided.getWeather weatherCallBack = new WeatherProvided.getWeather() {
        @Override
        public void weather(WeatherResult weatherResult) {
            Log.d("MyLog", weatherResult.toString());
        }

        @Override
        public void failed(String msg) {
            Log.d("MyLog", msg);
        }
    };

```
###### The Return Object Data:
```java
         double temp_c;
         double temp_f;
         double wind_kph;
         double pressure_mb;
         int humidity;
         double precip_mm;
         double cloud;
         double feelslike_c;
         double feelslike_f;
         String cityname;
         String country;

```




