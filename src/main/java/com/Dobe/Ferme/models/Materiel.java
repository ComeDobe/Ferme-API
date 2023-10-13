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

public class Materiel extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Materiel;
    private String Nom;
    private String Type;
    private String Marque;
    private String Modele;
    @Column(name = "Date_Achat")
    private LocalDate DateAchat;
    @Column(name ="Date_Reparation")
    private LocalDate DateReparation;
    @Column(name = "Etat_Materiel")
    private String EtatMateriel;
    @ManyToOne
    @JoinColumn(name = "Id_Ferme")
    private Ferme ferme;


}
