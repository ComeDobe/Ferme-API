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
@Table(name = " ESPECE ")

public class Espece extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id_Espece")
    private Integer id;
    @Column(name = "Nom_Commun")
    private String nomCommun;
    @Column(name = "Nom_Scientifique")
    private String nomScientifique;
    @Column(name = "Duree_Vie")
    private LocalDate dureeVie;
    private Integer poids;
    @ManyToOne
    @JoinColumn(name = "Id_Animal")
    private Animal animal;


}
