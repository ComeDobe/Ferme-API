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
@Table(name = " EMPLOYE ")

public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Employe;

    private String Nom;
    private String Prenom;
    private LocalDate Date_Naissance;
    private String AdresService;
    private String Telephone;
    private String Rang;
    private LocalDate Date_Embaucher;
    @ManyToOne
    @JoinColumn(name = "Id_Tache")
    private Tache tache;


}
