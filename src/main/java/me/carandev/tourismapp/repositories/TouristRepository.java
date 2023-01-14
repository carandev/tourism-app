package me.carandev.tourismapp.repositories;

import me.carandev.tourismapp.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import me.carandev.tourismapp.entities.Tourist;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
}
