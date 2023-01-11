package me.carandev.tourismapp.services;

import java.util.List;

import me.carandev.tourismapp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import me.carandev.tourismapp.entities.City;
import me.carandev.tourismapp.repositories.CityRepository;

@Service
public class CityService {
  @Autowired
  CityRepository cityRepository;

  public List<City> findAllCities() {
    return cityRepository.findAll();
  }

  public City findCityById(Long id) {
    return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City", "id", id));
  }

  public City addCity(City city) {
    return cityRepository.save(city);
  }

  public City updateCity(City city, Long id){
    City cityToUpdate = cityRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("City", "id", id));

    cityToUpdate.setName(city.getName());
    cityToUpdate.setPopulation(city.getPopulation());
    cityToUpdate.setMoreReservedHotel(city.getMoreReservedHotel());
    cityToUpdate.setTouristAttraction(city.getTouristAttraction());

    return cityRepository.save(cityToUpdate);
  }

  public void deleteCityById(Long id) {
    cityRepository.deleteById(id);
  }
}
