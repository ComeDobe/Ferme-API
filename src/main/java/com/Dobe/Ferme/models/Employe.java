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

public class Employe extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id_Employe")
    private Integer Id;
    private String Nom;
    private String Prenom;
    @Column(name = "Date_Naissance")
    private LocalDate DateNaissance;
    private String Adresse;
    private String Telephone;
    private String Rang;
    @Column(name = "Date_Embaucher")
    private LocalDate DateEmbaucher;
    @ManyToOne
    @JoinColumn(name = "Id_Tache")
    private Tache tache;


}
