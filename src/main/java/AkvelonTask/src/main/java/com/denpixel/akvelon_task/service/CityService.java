package com.denpixel.akvelon_task.service;

import com.denpixel.akvelon_task.model.City;
import com.denpixel.akvelon_task.model.CityResponse;
import com.denpixel.akvelon_task.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityService implements CityCRUD {

    private CityRepository repository;

    @Autowired
    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public CityResponse getById(int id) {
        City city = repository.findById(id)
                .orElseThrow();

        return CityResponse.cityResponseFromCity(city);
    }

    @Override
    public CityResponse getByName(String name) {
        City city = repository.findByName(name)
                .orElseThrow();

        return CityResponse.cityResponseFromCity(city);
    }

    @Override
    public Set<CityResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(CityResponse::cityResponseFromCity)
                .collect(Collectors.toSet());
    }

    @Override
    public void create(City city) {
        repository.save(city);
    }

    @Override
    public void updateById(int id, City city) {
        City persistenceCity = repository.findById(id).orElseThrow();

        persistenceCity.setName(city.getName());

        repository.save(persistenceCity);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        repository.deleteByName(name);
    }
}
