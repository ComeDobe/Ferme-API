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

public class Recolte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Recolte;
    private LocalDate Date_Recolte;
    private Integer Quantity_Produite;
    private String Qualite_Produite;
    @ManyToOne
    @JoinColumn(name = "Id_plantation")
    private  Plantation plantation;
}
