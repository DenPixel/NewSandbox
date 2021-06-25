package com.denpixel.akvelon_task.model;

public class CityResponse {
    private String name;

    public static CityResponse cityResponseFromCity(City city) {
        CityResponse response = new CityResponse();

        response.setName(city.getName());

        return response;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
