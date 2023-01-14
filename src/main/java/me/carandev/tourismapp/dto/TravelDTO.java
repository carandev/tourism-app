package me.carandev.tourismapp.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class TravelDTO {
  private Long id;
  private Date date;
  private Long touristId;
  private Long cityId;
}
