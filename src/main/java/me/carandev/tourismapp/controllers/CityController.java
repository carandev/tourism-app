package me.carandev.tourismapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import me.carandev.tourismapp.entities.City;
import me.carandev.tourismapp.services.CityService;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
public class CityController {
  @Autowired
  CityService cityService;

  @PostMapping(value = "/cities")
  public ResponseEntity<City> addCity(@RequestBody City city) {
    City savedCity = cityService.addCity(city);

    return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
  }

  @PostMapping(value = "/cities/{id}")
  public ResponseEntity<City> updateCity(@RequestBody City city, @PathVariable Long id) {
    City updatedCity = cityService.updateCity(city, id);

    return new ResponseEntity<>(updatedCity, HttpStatus.OK);
  }

  @DeleteMapping(value = "/cities/{id}")
  public ResponseEntity<String> deleteCity(@PathVariable Long id) {
    cityService.deleteCityById(id);

    return new ResponseEntity<>("City deleted successfully", HttpStatus.OK);
  }

  @GetMapping(value = "/cities/{id}")
  public ResponseEntity<City> getCity(@PathVariable Long id) {
    City city = cityService.findCityById(id);

    return new ResponseEntity<>(city, HttpStatus.OK);
  }

  @GetMapping(value = "/cities")
  public ResponseEntity<List<City>> getAllCities() {
    List<City> cities = cityService.findAllCities();

    return new ResponseEntity<>(cities, HttpStatus.OK);
  }

}
