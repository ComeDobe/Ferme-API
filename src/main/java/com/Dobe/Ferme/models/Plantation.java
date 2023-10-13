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
@Table(name = " PLANTATION ")

public class Plantation extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Plantation;
    @Column(name = "Quantite_Plantee")
    private Integer QuantitePlantee;
    @ManyToOne
    @JoinColumn(name = "Id_Parcelle")
    private Parcelle parcelle;
}
