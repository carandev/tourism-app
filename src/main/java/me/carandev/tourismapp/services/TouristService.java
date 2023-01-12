package me.carandev.tourismapp.services;

import java.sql.Date;
import java.util.List;

import me.carandev.tourismapp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.carandev.tourismapp.dto.TouristDTO;
import me.carandev.tourismapp.entities.City;
import me.carandev.tourismapp.entities.Tourist;
import me.carandev.tourismapp.repositories.CityRepository;
import me.carandev.tourismapp.repositories.TouristRepository;

@Service
public class TouristService {
  @Autowired
  TouristRepository touristRepository;
  @Autowired
  CityRepository cityRepository;

  public List<Tourist> findAllTourists() {
    return touristRepository.findAll();
  }

  public Tourist findTouristById(Long id) {
    return touristRepository.findById(id).orElse(null);
  }

  public TouristDTO addTourist(TouristDTO tourist) {
    City city = cityRepository.findById(tourist.getCityId())
            .orElseThrow(() -> new ResourceNotFoundException("City", "id", tourist.getCityId()));


    Tourist newTourist = dtoToTourist(tourist);

    newTourist.setDestination(city);

    Tourist touristSaved = touristRepository.save(newTourist);

    return touristToDTO(touristSaved);
  }

  public List<TouristDTO> checkDateTravel(Long cityId, String date){
    City city = cityRepository.findById(cityId)
            .orElseThrow(() -> new ResourceNotFoundException("City", "id", cityId));

    Date travelDate = Date.valueOf(date);

    List<Tourist> tourists = touristRepository.findTouristsByDestinationAndTravelDate(city, travelDate);

    return tourists.stream().map(this::touristToDTO).toList();

  }

  public List<TouristDTO> findTouristByDestination(Long cityId){
    City city = cityRepository.findById(cityId)
            .orElseThrow(() -> new ResourceNotFoundException("City", "id", cityId));

    List<Tourist> tourists = touristRepository.findTouristByDestination(city);

    return tourists.stream().map(this::touristToDTO).toList();
  }

  public TouristDTO updateTourist(Long id, TouristDTO touristDto) {
    Tourist tourist = touristRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Tourist", "id", id));

    tourist.setName(touristDto.getName());
    tourist.setBirthDate(touristDto.getBirthDate());
    tourist.setIdentification(touristDto.getIdentification());
    tourist.setDestination(cityRepository.findById(touristDto.getCityId())
            .orElseThrow(() -> new ResourceNotFoundException("City", "id", touristDto.getCityId())));
    tourist.setIdentificationType(touristDto.getIdentificationType());
    tourist.setTravelFrequency(touristDto.getTravelFrequency());
    tourist.setTravelBudget(touristDto.getTravelBudget());
    tourist.setCard(touristDto.isCard());

    Tourist touristSaved = touristRepository.save(tourist);

    return touristToDTO(touristSaved);
  }

  public void deleteTouristById(Long id) {
    touristRepository.deleteById(id);
  }

  public TouristDTO touristToDTO(Tourist tourist) {
    TouristDTO touristDTO = new TouristDTO();
    touristDTO.setId(tourist.getId());
    touristDTO.setName(tourist.getName());
    touristDTO.setBirthDate(tourist.getBirthDate());
    touristDTO.setIdentification(tourist.getIdentification());
    touristDTO.setIdentificationType(tourist.getIdentificationType());
    touristDTO.setTravelFrequency(tourist.getTravelFrequency());
    touristDTO.setCityId(tourist.getDestination().getId());
    touristDTO.setTravelBudget(tourist.getTravelBudget());
    touristDTO.setCard(tourist.isCard());

    return touristDTO;
  }

  public Tourist dtoToTourist(TouristDTO touristDTO){
    Tourist tourist = new Tourist();
    tourist.setName(touristDTO.getName());
    tourist.setBirthDate(touristDTO.getBirthDate());
    tourist.setIdentification(touristDTO.getIdentification());
    tourist.setIdentificationType(touristDTO.getIdentificationType());
    tourist.setTravelFrequency(touristDTO.getTravelFrequency());
    tourist.setTravelBudget(touristDTO.getTravelBudget());
    tourist.setCard(touristDTO.isCard());

    return tourist;
  }
}
