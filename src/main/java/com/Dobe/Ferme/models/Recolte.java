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
    private Integer id;
    @Column(name = "Date_Recolte")
    private LocalDate dateRecolte;
    @Column(name = "Quantite_Produite")
    private Integer quantiteProduite;
    @Column(name = "Qualite_Produite")
    private String qualiteProduite;
    @ManyToOne
    @JoinColumn(name = "Id_plantation")
    private  Plantation plantation;
}
