package com.Dobe.Ferme.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = " ESPECE ")

public class Espece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Espece;

    private String Nom_Commun;
    private String Nom_Scientifique;
    private LocalDate Duree_Vie;
    private Integer Poids;
    @ManyToOne
    @JoinColumn(name = "Id_Animal")
    private Animal animal;


}
