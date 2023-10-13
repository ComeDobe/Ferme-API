package com.Dobe.Ferme.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = " ANIMAL ")

public class Animal extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Animal;

    private String Nom;
    private String Sexe;
    private String Sante;
    private Integer Poids;

    @ManyToOne
    @JoinColumn(name = "Tache")
    private Tache tache;

}
