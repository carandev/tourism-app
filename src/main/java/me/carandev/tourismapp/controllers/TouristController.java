package me.carandev.tourismapp.controllers;

import java.util.List;

import me.carandev.tourismapp.dto.TouristDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.carandev.tourismapp.entities.Tourist;
import me.carandev.tourismapp.services.TouristService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class TouristController {

  @Autowired
  TouristService touristService;

  @PostMapping("/tourists")
  public ResponseEntity<TouristDTO> addTourist(@RequestBody TouristDTO tourist) {
    TouristDTO touristSaved = touristService.addTourist(tourist);

    return new ResponseEntity<>(touristSaved, HttpStatus.CREATED);
  }

  @GetMapping("/tourists")
  public List<Tourist> findAllTourists() {
    return touristService.findAllTourists();
  }
}
