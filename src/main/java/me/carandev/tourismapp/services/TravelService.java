package me.carandev.tourismapp.services;

import me.carandev.tourismapp.dto.TravelDTO;
import me.carandev.tourismapp.entities.City;
import me.carandev.tourismapp.entities.Tourist;
import me.carandev.tourismapp.entities.Travel;
import me.carandev.tourismapp.exception.ResourceNotFoundException;
import me.carandev.tourismapp.repositories.CityRepository;
import me.carandev.tourismapp.repositories.TouristRepository;
import me.carandev.tourismapp.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TravelService {
  @Autowired
  TravelRepository travelRepository;
  @Autowired
  CityRepository cityRepository;
  @Autowired
  TouristRepository touristRepository;

  public Travel addTravel(TravelDTO travel) {

    Travel newTravel = dtoToTravel(travel);

    return travelRepository.save(newTravel);
  }

  public Travel getTravelByDateAndCity(Long cityId, Date date) {
    City city = cityRepository.findById(cityId)
        .orElseThrow(() -> new ResourceNotFoundException("City", "id", cityId));

    return travelRepository.findTravelByDestinationAndTravelDate(city, date);
  }

  public List<Travel> getTravelsByTourist(Long id) {

    Tourist tourist = touristRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Tourist", "id", id));

    return travelRepository.findAllByTouristsContaining(tourist);

  }

  public List<Travel> getTravels() {
    return travelRepository.findAll();
  }

  public void deleteTravel(Long id) {
    travelRepository.deleteById(id);
  }

  public Travel dtoToTravel(TravelDTO travelDTO) {
    City city = cityRepository.findById(travelDTO.getCityId())
        .orElseThrow(() -> new ResourceNotFoundException("City", "id", travelDTO.getCityId()));

    Tourist tourist = touristRepository.findById(travelDTO.getTouristId())
        .orElseThrow(() -> new ResourceNotFoundException("Tourist", "id", travelDTO.getTouristId()));

    Travel travel = travelRepository.findTravelByDestinationAndTravelDate(city, travelDTO.getDate());

    if (travel == null) {
      travel = new Travel();
      travel.setDestination(city);
      travel.setTravelDate(travelDTO.getDate());
      travel.setTourists(List.of(tourist));
    } else {
      travel.setDestination(city);
      travel.getTourists().add(tourist);
      travel.setTravelDate(travelDTO.getDate());
    }

    return travel;
  }
}
