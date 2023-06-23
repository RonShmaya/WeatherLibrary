package com.ron.weatherlib;

public class WeatherResult {
    private MyLocation location;
    private WeatherInfo current;

    public WeatherResult() {
    }

    public MyLocation getLocation() {
        return location;
    }

    public WeatherResult setLocation(MyLocation location) {
        this.location = location;
        return this;
    }

    public WeatherInfo getCurrent() {
        return current;
    }

    public WeatherResult setCurrent(WeatherInfo current) {
        this.current = current;
        return this;
    }

    @Override
    public String toString() {
        return "WeatherResult{" +
                "location=" + location +
                ", current=" + current +
                '}';
    }

    public class MyLocation {
        private String name;
        private String country;

        public MyLocation(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public MyLocation setName(String name) {
            this.name = name;
            return this;
        }

        public String getCountry() {
            return country;
        }

        public MyLocation setCountry(String country) {
            this.country = country;
            return this;
        }

        @Override
        public String toString() {
            return "MyLocation{" +
                    "name='" + name + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }

    public class WeatherInfo {
        private double temp_c;
        private double temp_f;
        private double wind_kph;
        private double pressure_mb;
        private int humidity;
        private double precip_mm;
        private double cloud;
        private double feelslike_c;
        private double feelslike_f;

        public WeatherInfo() {
        }

        public double getTemp_c() {
            return temp_c;
        }

        public WeatherInfo setTemp_c(double temp_c) {
            this.temp_c = temp_c;
            return this;
        }

        public double getTemp_f() {
            return temp_f;
        }

        public WeatherInfo setTemp_f(double temp_f) {
            this.temp_f = temp_f;
            return this;
        }

        public double getWind_kph() {
            return wind_kph;
        }

        public WeatherInfo setWind_kph(double wind_kph) {
            this.wind_kph = wind_kph;
            return this;
        }

        public double getPressure_mb() {
            return pressure_mb;
        }

        public WeatherInfo setPressure_mb(double pressure_mb) {
            this.pressure_mb = pressure_mb;
            return this;
        }

        public int getHumidity() {
            return humidity;
        }

        public WeatherInfo setHumidity(int humidity) {
            this.humidity = humidity;
            return this;
        }

        public double getPrecip_mm() {
            return precip_mm;
        }

        public WeatherInfo setPrecip_mm(double precip_mm) {
            this.precip_mm = precip_mm;
            return this;
        }

        public double getCloud() {
            return cloud;
        }

        public WeatherInfo setCloud(double cloud) {
            this.cloud = cloud;
            return this;
        }

        public double getFeelslike_c() {
            return feelslike_c;
        }

        public WeatherInfo setFeelslike_c(double feelslike_c) {
            this.feelslike_c = feelslike_c;
            return this;
        }

        public double getFeelslike_f() {
            return feelslike_f;
        }

        public WeatherInfo setFeelslike_f(double feelslike_f) {
            this.feelslike_f = feelslike_f;
            return this;
        }

        @Override
        public String toString() {
            return "WeatherInfo{" +
                    "temp_c=" + temp_c +
                    ", temp_f=" + temp_f +
                    ", wind_kph=" + wind_kph +
                    ", pressure_mb=" + pressure_mb +
                    ", humidity=" + humidity +
                    ", precip_mm=" + precip_mm +
                    ", cloud=" + cloud +
                    ", feelslike_c=" + feelslike_c +
                    ", feelslike_f=" + feelslike_f +
                    '}';
        }
    }
}
