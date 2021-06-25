package com.denpixel.akvelon_task.service;

import com.denpixel.akvelon_task.model.City;
import com.denpixel.akvelon_task.model.CityResponse;

import java.util.Set;

public interface CityCRUD {
    CityResponse getById(int id);

    CityResponse getByName(String name);

    Set<CityResponse> getAll();

    void create(City city);

    void updateById(int id, City city);

    void deleteById(int id);

    void deleteByName(String name);
}
