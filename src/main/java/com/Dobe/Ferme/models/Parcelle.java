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

public class Parcelle extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id_Parcelle")
    private Integer id;
    private String nom;
    private String dimension;
    @Column(name = "Type_Sol")
    private String typeSol;
    @ManyToOne
    @JoinColumn(name = "Id_Tache")
    private Tache tache;

}
