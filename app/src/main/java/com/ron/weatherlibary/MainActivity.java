package com.ron.weatherlibary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private ImageView weather_ICN_icon;
    private AutoCompleteTextView weather_ATXT_city;
    private CheckBox weather_CBX_Precipitation;
    private CheckBox weather_CBX_WindSpeed;
    private CheckBox weather_CBX_Humidity;
    private CheckBox weather_CBX_Pressure;
    private CheckBox weather_CBX_sun;
    private CheckBox weather_CBX_Temperature;
    private MaterialButton weather_BTN_go;
    private String city;
    private boolean isHumidity=false;
    private boolean isPrecipitation=false;
    private boolean isWindSpeed=false;
    private boolean isPressure=false;
    private boolean isSun=false;
    private boolean isTemperature=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initViews();
    }

    private void initViews() {
        weather_BTN_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city= weather_ATXT_city.getText().toString();
                if (city == null || city.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter city", Toast.LENGTH_SHORT).show();
                    return;
                }
                WeatherRequestDet weatherRequestDet = new WeatherRequestDet(city);
                weatherRequestDet
                        .addProperty(WeatherRequestDet.HUMIDITY,weather_CBX_Humidity.isChecked() )
                        .addProperty(WeatherRequestDet.PRECIPITATION, weather_CBX_Precipitation.isChecked())
                        .addProperty(WeatherRequestDet.COUNTRY, weather_CBX_sun.isChecked())
                        .addProperty(WeatherRequestDet.TEMPERATURE_C, weather_CBX_Temperature.isChecked())
                        .addProperty(WeatherRequestDet.TEMPERATURE_F, weather_CBX_Temperature.isChecked())
                        .addProperty(WeatherRequestDet.FEELS_C, weather_CBX_Temperature.isChecked())
                        .addProperty(WeatherRequestDet.FEELS_F, weather_CBX_Temperature.isChecked())
                        .addProperty(WeatherRequestDet.PRESSURE, weather_CBX_Pressure.isChecked())
                        .addProperty(WeatherRequestDet.WIND_SPEED, weather_CBX_WindSpeed.isChecked());

                DataManager.getDataManager().setWeatherRequestDet(weatherRequestDet);
                go_next(ResultActivity.class);
            }
        });
    }

    private void findViews(){
        weather_ICN_icon=findViewById(R.id.weather_ICN_icon);
        weather_ATXT_city=findViewById(R.id.weather_ATXT_city);
        weather_CBX_Precipitation=findViewById(R.id.weather_CBX_Precipitation);
        weather_CBX_WindSpeed=findViewById(R.id.weather_CBX_WindSpeed);
        weather_CBX_Humidity=findViewById(R.id.weather_CBX_Humidity);
        weather_CBX_Pressure=findViewById(R.id.weather_CBX_Pressure);
        weather_CBX_sun=findViewById(R.id.weather_CBX_sun);
        weather_CBX_Temperature=findViewById(R.id.weather_CBX_Temperature);
        weather_BTN_go=findViewById(R.id.weather_BTN_go);
    }

    private <T extends AppCompatActivity> void go_next(Class<T> nextActivity) {
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
        finish();
    }
}