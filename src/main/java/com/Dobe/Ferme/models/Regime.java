package com.Dobe.Ferme.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = " REGIME ")

public class Regime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Regime;
    private Integer Quantite_JournalieredValue;
    private LocalDate Duree_Regime;
    @ManyToOne
    @JoinColumn(name = "Id_Animal")
    private Animal animal;

}
