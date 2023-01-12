package me.carandev.tourismapp.repositories;

import me.carandev.tourismapp.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import me.carandev.tourismapp.entities.Tourist;

import java.sql.Date;
import java.util.List;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
    public List<Tourist> findTouristsByDestinationAndTravelDate(City destination, Date travelDate);

    public List<Tourist> findTouristByDestination(City destination);
}
