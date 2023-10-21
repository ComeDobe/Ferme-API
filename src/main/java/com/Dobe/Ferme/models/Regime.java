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

    @Column(name = "Id_Regime")
    private Integer id;
    @Column(name = "Quantite_Journaliere")
    private Integer quantite;
    @Column(name = "Duree_Regime")
    private LocalDate dureeRegime;
    @ManyToOne
    @JoinColumn(name = "Id_Animal")
    private Animal animal;

}
