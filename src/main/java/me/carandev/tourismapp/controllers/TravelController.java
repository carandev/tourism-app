package me.carandev.tourismapp.controllers;

import me.carandev.tourismapp.dto.TravelDTO;
import me.carandev.tourismapp.entities.Travel;
import me.carandev.tourismapp.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
public class TravelController {
  @Autowired
  TravelService travelService;

  @PostMapping("/travels")
  public ResponseEntity<Travel> addTravel(@RequestBody TravelDTO travel) {
    Travel travelSaved = travelService.addTravel(travel);

    return new ResponseEntity<>(travelSaved, HttpStatus.CREATED);
  }

  @DeleteMapping("/travels/{id}")
  public ResponseEntity<String> deleteTravel(@PathVariable Long id) {
    travelService.deleteTravel(id);

    return new ResponseEntity<>("Travel deleted successfully", HttpStatus.OK);
  }

  @GetMapping("/travels/tourists/{id}")
  public ResponseEntity<List<Travel>> getTravelsByTourist(@PathVariable Long id) {
    List<Travel> travels = travelService.getTravelsByTourist(id);

    return new ResponseEntity<>(travels, HttpStatus.OK);
  }

  @GetMapping("travels/{cityId}/{date}")
  public ResponseEntity<Travel> getTravelByDateAndCity(@PathVariable Long cityId, @PathVariable Date date) {
    Travel travel = travelService.getTravelByDateAndCity(cityId, date);

    return new ResponseEntity<>(travel, HttpStatus.OK);
  }

  @GetMapping("/travels")
  public ResponseEntity<List<Travel>> getTravels() {
    List<Travel> travels = travelService.getTravels();

    return new ResponseEntity<>(travels, HttpStatus.OK);
  }

}
