package me.carandev.tourismapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.carandev.tourismapp.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
