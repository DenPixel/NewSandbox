package com.denpixel.akvelon_task.controller;

import com.denpixel.akvelon_task.model.City;
import com.denpixel.akvelon_task.model.CityResponse;
import com.denpixel.akvelon_task.model.WeatherResponse;
import com.denpixel.akvelon_task.service.CityCRUD;
import com.denpixel.akvelon_task.service.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityCRUD crud;

    private final WeatherData weatherData;

    @Autowired
    public CityController(CityCRUD crud, WeatherData weatherData) {
        this.crud = crud;
        this.weatherData = weatherData;
    }

    @GetMapping
    public Set<CityResponse> getCites() {
        return crud.getAll();
    }

    @GetMapping("/{id}")
    public CityResponse getCityById(@PathVariable int id) {
        return crud.getById(id);
    }

    @GetMapping("/{name}")
    public CityResponse getCityByName(@PathVariable String name) {
        return crud.getByName(name);
    }

    @PostMapping
    public void create(@RequestBody City city) {
        crud.create(city);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable int id, @RequestBody City city) {
        crud.updateById(id, city);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        crud.deleteById(id);
    }

    @GetMapping("/{id}/weather/current")
    public WeatherResponse getCurrentWeatherByCityId(@PathVariable int id) {
        String name = crud.getById(id).getName();
        return weatherData.getDataByCityName(name);
    }

    //    @GetMapping("/{name}/weather/current")
    public WeatherResponse getCurrentWeatherByCityName(@PathVariable String name) {
        return weatherData.getDataByCityName(name);
    }
}
