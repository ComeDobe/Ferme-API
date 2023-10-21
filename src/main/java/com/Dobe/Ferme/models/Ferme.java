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
@Table(name = " FERME ")

public class Ferme extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id_Ferme")
    private Integer id;
    private String nom;
    private String adresse;
    private String surface;
    private String sections;
    @ManyToOne
    @JoinColumn(name = "Id_Utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "Id_Animal")
    private Animal animal;


    @ManyToOne
    @JoinColumn(name = "Id_Parcelle")
    private Parcelle parcelle;


}
