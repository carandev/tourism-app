package me.carandev.tourismapp.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tourists")
@Data
public class Tourist {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private Date birthDate;
  private String identification;
  private String identificationType;
  private int travelFrequency;
  private double travelBudget;
  private boolean card;
}
