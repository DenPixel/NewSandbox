package com.denpixel.akvelon_task.service;

import com.denpixel.akvelon_task.model.WeatherResponse;

public interface WeatherData {
    WeatherResponse getDataByCityName(String cityName);
}
