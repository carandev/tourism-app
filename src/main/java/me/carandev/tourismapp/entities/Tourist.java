package me.carandev.tourismapp.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
  @OneToOne
  private City destination;
  private double travelBudget;
  private boolean card;
}
