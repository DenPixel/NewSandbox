package com.denpixel.akvelon_task.model;

import java.time.Instant;

public class WeatherResponse {
    private double temperature;

    private double temperatureMin;

    private double temperatureMax;

    private double feelsLike;

    private double windSpeed;

    private String description;

    private Instant timestamp;

    private int cityId;

    public static WeatherResponse weatherResponseFromWeather(Weather weather) {
        WeatherResponse response = new WeatherResponse();

        response.setTemperature(weather.getTemperature());
        response.setTemperatureMin(weather.getTemperatureMin());
        response.setTemperatureMax(weather.getTemperatureMax());
        response.setFeelsLike(weather.getFeelsLike());
        response.setWindSpeed(weather.getWindSpeed());
        response.setDescription(weather.getDescription());
        response.setTimestamp(weather.getTimestamp());
        response.setCityId(weather.getCity().getId());

        return response;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
