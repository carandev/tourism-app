package me.carandev.tourismapp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "travels")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City destination;
    @ManyToMany
    @JoinColumn(name = "tourist_id", nullable = false)
    private List<Tourist> tourists;
    private Date travelDate;
}
