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
    private Integer id;
    private String nom;
    private String prenom;
    @Column(name = "Date_Naissance")
    private LocalDate dateNaissance;
    private String adresse;
    private String telephone;
    private String rang;
    @Column(name = "Date_Embaucher")
    private LocalDate dateEmbaucher;
    @ManyToOne
    @JoinColumn(name = "Id_Tache")
    private Tache tache;


}
