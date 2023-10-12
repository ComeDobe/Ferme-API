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
@Table(name = " PARCELLE ")

public class Parcelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id_Parcelle;
    private String Nom;
    private String Dimension;
    private String Type_Sol;
    @ManyToOne
    @JoinColumn(name = "Id_Ferme")
    private  Ferme ferme;
    @ManyToOne
    @JoinColumn(name = "Id_Tache")
    private Tache tache;

}
