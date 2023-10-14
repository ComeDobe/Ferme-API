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
@Table(name = " RECOLTE ")

public class Recolte extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id_Recolte")
    private Integer Id;
    @Column(name = "Date_Recolte")
    private LocalDate DateRecolte;
    @Column(name = "Quantite_Produite")
    private Integer QuantiteProduite;
    @Column(name = "Qualite_Produite")
    private String QualiteProduite;
    @ManyToOne
    @JoinColumn(name = "Id_plantation")
    private  Plantation plantation;
}
