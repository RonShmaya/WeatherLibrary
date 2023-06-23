# WeatherLibrary
[![](https://jitpack.io/v/RonShmaya/WeatherLibrary.svg)](https://jitpack.io/#RonShmaya/WeatherLibrary)

Library for getting all weather's properties in an easy way by city name.
The Library Uses Retrofit for getting the data from https://www.weatherapi.com/api


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




