package com.denpixel.akvelon_task.repository;

import com.denpixel.akvelon_task.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    Optional<City> findByName(String name);

    void deleteByName(String name);
}
