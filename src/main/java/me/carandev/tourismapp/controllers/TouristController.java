package me.carandev.tourismapp.controllers;

import java.util.List;

import me.carandev.tourismapp.dto.TouristDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/tourists/{id}")
  public ResponseEntity<TouristDTO> updateTourist(@RequestBody TouristDTO tourist, @PathVariable Long id) {
    TouristDTO touristSaved = touristService.updateTourist(id, tourist);

    return new ResponseEntity<>(touristSaved, HttpStatus.OK);
  }

  @GetMapping("/tourists")
  public ResponseEntity<List<Tourist>> findAllTourists() {
    List<Tourist> tourists = touristService.findAllTourists();
    return new ResponseEntity<>(tourists, HttpStatus.OK);
  }

  @GetMapping("/tourists/{date}/{cityId}")
  public ResponseEntity<List<TouristDTO>> findTouristByDateAndDestination(@PathVariable String date, @PathVariable Long cityId) {
    List<TouristDTO> tourists = touristService.checkDateTravel(cityId, date);

    return new ResponseEntity<>(tourists, HttpStatus.OK);
  }

  @GetMapping("/tourists/{cityId}")
public ResponseEntity<List<TouristDTO>> findTouristByDestination(@PathVariable Long cityId) {
    List<TouristDTO> tourists = touristService.findTouristByDestination(cityId);

    return new ResponseEntity<>(tourists, HttpStatus.OK);
  }

  @DeleteMapping("/tourists/{id}")
  public ResponseEntity<String> deleteTourist(@PathVariable Long id) {
    touristService.deleteTouristById(id);

    return new ResponseEntity<>("Tourist deleted successfully", HttpStatus.OK);
  }
}
