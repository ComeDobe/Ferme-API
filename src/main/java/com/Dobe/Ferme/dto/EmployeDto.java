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


    private Integer Id;
    private String Nom;
    private String Prenom;

    private LocalDate DateNaissance;
    private String Adresse;
    private String Telephone;
    private String Rang;

    private LocalDate DateEmbaucher;

    private Integer tacheId;
    public static EmployeDto fromEntity(Employe employe) {
        return EmployeDto.builder()
                .Id(employe.getId())
                .Nom(employe.getNom())
                .Prenom(employe.getPrenom())
                .DateNaissance(employe.getDateNaissance())
                .Adresse(employe.getAdresse())
                .Telephone(employe.getTelephone())
                .Rang(employe.getRang())
                .DateEmbaucher(employe.getDateEmbaucher())
                .tacheId(employe.getTache().getId())
                .build();
    }

    public static Employe toEntity(EmployeDto employe) {

       Employe employeModel = new Employe();
       employeModel.setId(employe.getId());
       employeModel.setNom(employe.getNom());
       employeModel.setPrenom(employe.getPrenom());
       employeModel.setDateNaissance(employe.getDateNaissance());
       employeModel.setDateEmbaucher(employe.getDateEmbaucher());
       employeModel.setAdresse(employe.getAdresse());
       employeModel.setTelephone(employe.getTelephone());

       employeModel.setRang(employe.getRang());

        if (employe.getTacheId()!= null) {
            Tache tache = new Tache();
            tache.setId(employe.getTacheId());
            employeModel.setTache(tache);
        }

        return employeModel;
    }

    }



