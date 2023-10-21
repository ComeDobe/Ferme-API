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

    @Column(name = "Id_Animal")
    private Integer id;
    private String nom;
    private String sexe;
    private String sante;
    private Integer poids;

    @ManyToOne
    @JoinColumn(name = "Tache")
    private Tache tache;

}
