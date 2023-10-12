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
@Table(name = " MATERIEL ")

public class Materiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Materiel;
    private String Nom;
    private String Type;
    private String Marque;
    private String Modele;
    private LocalDate Date_Achat;
    private LocalDate Date_Reparation;
    private String Etat_Materiel;
    @ManyToOne
    @JoinColumn(name = "Id_Ferme")
    private Ferme ferme;


}
