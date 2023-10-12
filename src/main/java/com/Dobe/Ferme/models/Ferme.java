package com.Dobe.Ferme.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = " FERME ")

public class Ferme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Ferme;

    private String Nom;
    private String Adresse;
    private String Surface;
    private String Sections;
    @ManyToOne
    @JoinColumn(name = "Id_Utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "Id_Animal")
    private Animal animal;



}
