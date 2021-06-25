package com.denpixel.akvelon_task.repository;

import com.denpixel.akvelon_task.model.City;
import com.denpixel.akvelon_task.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, UUID> {

    Optional<Weather> findByCity(City city);
}
