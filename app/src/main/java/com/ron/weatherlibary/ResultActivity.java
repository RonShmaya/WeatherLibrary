package com.ron.weatherlibary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ron.weatherlib.WeatherProvided;
import com.ron.weatherlib.WeatherResult;

public class ResultActivity extends AppCompatActivity {

    private TextView result_TXT_temperature;
    private LinearLayout result_LLY_precipitation;
    private TextView result_TXT_precipitation;
    private LinearLayout result_LLY_wind;
    private TextView result_TXT_wind;
    private LinearLayout result_LLY_sun;
    private TextView result_TXT_Sunset;
    private LinearLayout result_LLY_pressure;
    private TextView result_TXT_pressure;
    private LinearLayout result_LLY_humidity;
    private TextView result_TXT_Humidity;
    private LinearLayout result_LLY_feels;
    private TextView result_TXT_feels;
    private TextView result_TXT_city;
    private ImageView result_TXT_back;
    private WeatherRequestDet weatherRequestDet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        weatherRequestDet = DataManager.getDataManager().getWeatherRequestDet();
        findViews();
        initActions();
        makeRequest();

    }

    private void makeRequest() {
        WeatherProvided.getInstance().setWeatherCallback(weatherCallBack)
                .execWeatherRequest(weatherRequestDet.getCity());
    }

    private void initActions() {
        result_TXT_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void findViews() {
        result_TXT_temperature = findViewById(R.id.result_TXT_temperature);
        result_LLY_precipitation = findViewById(R.id.result_LLY_precipitation);
        result_TXT_precipitation = findViewById(R.id.result_TXT_precipitation);
        result_LLY_wind = findViewById(R.id.result_LLY_wind);
        result_TXT_wind = findViewById(R.id.result_TXT_wind);
        result_LLY_sun = findViewById(R.id.result_LLY_sun);
        result_TXT_Sunset = findViewById(R.id.result_TXT_Sunset);
        result_LLY_pressure = findViewById(R.id.result_LLY_pressure);
        result_TXT_pressure = findViewById(R.id.result_TXT_pressure);
        result_LLY_humidity = findViewById(R.id.result_LLY_humidity);
        result_TXT_Humidity = findViewById(R.id.result_TXT_Humidity);
        result_LLY_feels = findViewById(R.id.result_LLY_feels);
        result_TXT_feels = findViewById(R.id.result_TXT_feels);
        result_TXT_city = findViewById(R.id.result_TXT_city);
        result_TXT_back = findViewById(R.id.result_TXT_back);

        result_TXT_city.setText(weatherRequestDet.getCity());
    }

    ;

    private WeatherProvided.getWeather weatherCallBack = new WeatherProvided.getWeather() {
        @Override
        public void weather(WeatherResult weatherResult) {
            Log.d("MyLog", weatherResult.toString());
            decideIfShowProp(
                    result_TXT_temperature,
                    result_TXT_temperature,
                    WeatherRequestDet.TEMPERATURE_C,
                    weatherResult.getCurrent().getTemp_c() + " C");
            decideIfShowProp(
                    result_LLY_precipitation,
                    result_TXT_precipitation,
                    WeatherRequestDet.PRECIPITATION,
                    weatherResult.getCurrent().getPrecip_mm() + "%");
            decideIfShowProp(
                    result_LLY_wind,
                    result_TXT_wind,
                    WeatherRequestDet.WIND_SPEED,
                    weatherResult.getCurrent().getWind_kph() + " KMPH");
            decideIfShowProp(
                    result_LLY_pressure,
                    result_TXT_pressure,
                    WeatherRequestDet.PRESSURE,
                    weatherResult.getCurrent().getPressure_mb() + " KMPH");
            decideIfShowProp(
                    result_LLY_humidity,
                    result_TXT_Humidity,
                    WeatherRequestDet.HUMIDITY,
                    weatherResult.getCurrent().getHumidity() + "%");
            decideIfShowProp(
                    result_LLY_feels,
                    result_TXT_feels,
                    WeatherRequestDet.FEELS_C,
                    weatherResult.getCurrent().getFeelslike_c() + " C");
            decideIfShowProp(
                    result_LLY_sun,
                    result_TXT_Sunset,
                    WeatherRequestDet.COUNTRY,
                    weatherResult.getLocation().getCountry());

        }

        @Override
        public void failed(String msg) {
            Log.d("MyLog", msg);
            result_TXT_temperature.setText("Failed...");
            hiddenAll();
            Toast.makeText(ResultActivity.this, msg, Toast.LENGTH_LONG).show();
        }
    };

    private void hiddenAll() {
        result_LLY_precipitation.setVisibility(View.GONE);
        result_LLY_wind.setVisibility(View.GONE);
        result_LLY_pressure.setVisibility(View.GONE);
        result_LLY_humidity.setVisibility(View.GONE);
        result_LLY_feels.setVisibility(View.GONE);
        result_LLY_sun.setVisibility(View.GONE);
    }

    private void decideIfShowProp(View layout, TextView txt, String propKey, String value) {
        if (weatherRequestDet.isNeedToShow(propKey)) {
            txt.setText(value);
            return;
        }
        layout.setVisibility(View.GONE);
    }
}