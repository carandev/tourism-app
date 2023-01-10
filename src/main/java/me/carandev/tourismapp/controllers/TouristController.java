package me.carandev.tourismapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.carandev.tourismapp.entities.Tourist;
import me.carandev.tourismapp.services.TouristService;

@RestController
public class TouristController {

  @Autowired
  TouristService touristService;

  @PostMapping("/tourists")
  public void addTourist(@RequestBody Tourist tourist) {
    touristService.addTourist(tourist);
  }

  @GetMapping("/tourists")
  public List<Tourist> findAllTourists() {
    return touristService.findAllTourists();
  }
}
