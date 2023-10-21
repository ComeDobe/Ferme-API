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

    @Column(name = "Id_Plantation")
    private Integer id;
    @Column(name = "Quantite_Plantee")
    private Integer quantitePlantee;
    @ManyToOne
    @JoinColumn(name = "Id_Parcelle")
    private Parcelle parcelle;
}
