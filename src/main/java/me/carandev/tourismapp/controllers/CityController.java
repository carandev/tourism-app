package me.carandev.tourismapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.carandev.tourismapp.entities.City;
import me.carandev.tourismapp.services.CityService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CityController {
  @Autowired
  CityService cityService;

  @PostMapping(value = "/cities")
  public void addCity(@RequestBody City city) {
    cityService.addCity(city);
  }

  @GetMapping(value = "/cities")
  public List<City> getAllCities() {
    return cityService.findAllCities();
  }

}
