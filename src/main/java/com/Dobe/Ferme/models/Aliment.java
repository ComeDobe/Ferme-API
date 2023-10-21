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
@Table(name = " ALIMENT ")

public class Aliment extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id_Aliment")
    private Integer id;
    private String nom;
    private String type;
    private String composition;
    private Integer prix;
    @ManyToOne
    @JoinColumn(name = "Id_Regime")
    private Regime regime;


}
