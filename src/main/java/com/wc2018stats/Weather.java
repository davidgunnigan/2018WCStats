package com.wc2018stats;

public class Weather {

    private String description;
    private String humidity;
    private String tempCelcius;
    private String tempFarenheit;
    private String windSpeed;

    public Weather(String humidity, String temp_celcius, String temp_farenheit, String wind_speed, String description) {
        this.humidity = humidity;
        this.tempCelcius = temp_celcius;
        this.tempFarenheit = temp_farenheit;
        this.windSpeed = wind_speed;
        this.description = description;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTempCelcius() {
        return tempCelcius;
    }

    public String getTempFarenheit() {
        return tempFarenheit;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getDescription() {
        return description;
    }
}
