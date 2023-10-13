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

public class Regime extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Regime;
    @Column(name = "Quantite_Journaliere")
    private Integer Quantite;
    @Column(name = "Duree_Regime")
    private LocalDate DureeRegime;
    @ManyToOne
    @JoinColumn(name = "Id_Animal")
    private Animal animal;

}
