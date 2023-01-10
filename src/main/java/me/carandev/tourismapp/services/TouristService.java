package me.carandev.tourismapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.carandev.tourismapp.entities.Tourist;
import me.carandev.tourismapp.repositories.TouristRepository;

@Service
public class TouristService {
  @Autowired
  TouristRepository touristRepository;

  public List<Tourist> findAllTourists() {
    return touristRepository.findAll();
  }

  public Tourist findTouristById(Long id) {
    return touristRepository.findById(id).orElse(null);
  }

  public void addTourist(Tourist tourist) {
    touristRepository.save(tourist);
  }

  public void deleteTouristById(Long id) {
    touristRepository.deleteById(id);
  }
}
