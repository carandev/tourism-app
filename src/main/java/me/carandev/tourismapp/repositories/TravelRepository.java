package me.carandev.tourismapp.repositories;

import me.carandev.tourismapp.entities.City;
import me.carandev.tourismapp.entities.Tourist;
import me.carandev.tourismapp.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
  public Travel findTravelByDestinationAndTravelDate(City destination, Date travelDate);

  public List<Travel> findAllByTouristsContaining(Tourist tourist);
}
