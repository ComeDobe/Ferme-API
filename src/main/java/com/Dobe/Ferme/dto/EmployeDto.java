package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Employe;
import com.Dobe.Ferme.models.Tache;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder

public class EmployeDto {


    private Integer id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String adresse;
    private String telephone;
    private String rang;

    private LocalDate dateEmbaucher;

    private TacheDto tache;
    public static EmployeDto fromEntity(Employe employe) {
        return EmployeDto.builder()
                .id(employe.getId())
                .nom(employe.getNom())
                .prenom(employe.getPrenom())
                .dateNaissance(employe.getDateNaissance())
                .adresse(employe.getAdresse())
                .telephone(employe.getTelephone())
                .rang(employe.getRang())
                .dateEmbaucher(employe.getDateEmbaucher())
                .tache(TacheDto.fromEntity(employe.getTache()))
                .build();
    }

    public static Employe toEntity(EmployeDto employe) {

        return Employe.builder()
                .id(employe.getId())
                .nom(employe.getNom())
                .prenom(employe.getPrenom())
                .dateNaissance(employe.getDateNaissance())
                .adresse(employe.getAdresse())
                .telephone(employe.getTelephone())
                .rang(employe.getRang())
                .dateEmbaucher(employe.getDateEmbaucher())
                .tache(TacheDto.toEntity(employe.getTache()))
                .build();
    }

    }



