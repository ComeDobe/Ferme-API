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

public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Animal;

    private String Nome;
    private String Sexe;
    private String Sante;
    private Integer Poids;

    @ManyToOne
    @JoinColumn(name = "Tache")
    private Tache tache;

}
