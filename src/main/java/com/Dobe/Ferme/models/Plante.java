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

public class Plante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id_Plante;

    @Column(name = "Nom_Scientifique")
    private String Nom;
    @Column(name = "Nom_Commun")
    private String pseudo;
    @Column(name = "Exigence_Climentique")
    private String Climent;
    @Column(name = "Exigence_Sol")
    private String Sol;
    @ManyToOne
    @JoinColumn(name = "Id_Plantation")
    private Plantation plantation;

}
