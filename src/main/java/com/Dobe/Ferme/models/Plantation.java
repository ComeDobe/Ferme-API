package com.Dobe.Ferme.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = " PLANTATION ")

public class Plantation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Plantation;
    private Integer Quantite_Plantee;
    @ManyToOne
    @JoinColumn(name = "Id_Parcelle")
    private Parcelle parcelle;
}
