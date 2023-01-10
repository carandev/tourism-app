package me.carandev.tourismapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    return cityRepository.findById(id).orElse(null);
  }

  public void addCity(City city) {
    cityRepository.save(city);
  }

  public void deleteCityById(Long id) {
    cityRepository.deleteById(id);
  }
}
