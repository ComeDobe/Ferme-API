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
@Table(name = " PLANTe ")

public class Plante extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id_Plante")
    private Integer  id;
    @Column(name = "Nom_Scientifique")
    private String nom;
    @Column(name = "Nom_Commun")
    private String pseudo;
    @Column(name = "Exigence_Climentique")
    private String climent;
    @Column(name = "Exigence_Sol")
    private String sol;
    @ManyToOne
    @JoinColumn(name = "Id_Plantation")
    private Plantation plantation;

}
