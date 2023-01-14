package me.carandev.tourismapp.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class TouristDTO {
  private Long id;
  private String name;
  private Date birthDate;
  private String identification;
  private String identificationType;
  private int travelFrequency;
  private double travelBudget;
  private boolean card;
}
