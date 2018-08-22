package com.wc2018stats;

public class Weather {

    private String description;
    private String humidity;
    private String temp_celcius;
    private String temp_farenheit;
    private String wind_speed;

    public Weather(String humidity, String temp_celcius, String temp_farenheit, String wind_speed, String description) {
        this.humidity = humidity;
        this.temp_celcius = temp_celcius;
        this.temp_farenheit = temp_farenheit;
        this.wind_speed = wind_speed;
        this.description = description;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTemp_celcius() {
        return temp_celcius;
    }

    public String getTemp_farenheit() {
        return temp_farenheit;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public String getDescription() {
        return description;
    }
}
