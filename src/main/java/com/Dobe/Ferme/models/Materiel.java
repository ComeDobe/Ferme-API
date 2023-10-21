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

    @Column(name = "Id_Materiel")
    private Integer id;
    private String nom;
    private String type;
    private String marque;
    private String modele;
    @Column(name = "Date_Achat")
    private LocalDate dateAchat;
    @Column(name ="Date_Reparation")
    private LocalDate dateReparation;
    @Column(name = "Etat_Materiel")
    private String etatMateriel;
    @ManyToOne
    @JoinColumn(name = "Id_Ferme")
    private Ferme ferme;


}
