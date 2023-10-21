package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Ferme;
import com.Dobe.Ferme.models.Materiel;
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
public class MaterielDto {


    private Integer id;
    private String nom;
    private String type;
    private String marque;
    private String modele;
    private LocalDate dateAchat;
    private LocalDate dateReparation;
    private String etatMateriel;
    private FermeDto ferme;

    public static MaterielDto fromEntity (Materiel materiel) {
        return MaterielDto.builder()
                .id(materiel.getId())
                .nom(materiel.getNom())
                .type(materiel.getType())
                .marque(materiel.getMarque())
                .modele(materiel.getModele())
                .dateAchat(materiel.getDateAchat())
                .dateReparation(materiel.getDateReparation())
                .etatMateriel(materiel.getEtatMateriel())
                .ferme(FermeDto.fromEntity((materiel.getFerme())))
                .build();
    }
    public static Materiel toEntity (MaterielDto materiel) {
        return Materiel.builder()
                .id(materiel.getId())
                .nom(materiel.getNom())
                .type(materiel.getType())
                .marque(materiel.getMarque())
                .modele(materiel.getModele())
                .dateAchat(materiel.getDateAchat())
                .dateReparation(materiel.getDateReparation())
                .etatMateriel(materiel.getEtatMateriel())
                .ferme(FermeDto.toEntity((materiel.getFerme())))
                .build();

    }
}
