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
    private Integer Id;
    private String Nom;
    private String Type;
    private String Composition;
    private Integer Prix;
    @ManyToOne
    @JoinColumn(name = "Id_Regime")
    private Regime regime;


}
