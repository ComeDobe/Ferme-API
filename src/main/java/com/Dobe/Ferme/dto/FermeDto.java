package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Animal;
import com.Dobe.Ferme.models.Ferme;
import com.Dobe.Ferme.models.Parcelle;
import com.Dobe.Ferme.models.Utilisateur;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Getter
@Setter
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FermeDto {

    private Integer id;
    private String nom;
    private String adresse;
    private String surface;
    private String sections;
    private UtilisateurDto utilisateur;
    private AnimalDto animal;
    private ParcelleDto parcelle;

    public static  FermeDto fromEntity (Ferme ferme) {

        return FermeDto.builder()
                .id(ferme.getId())
                .nom(ferme.getNom())
                .adresse(ferme.getAdresse())
                .surface(ferme.getSurface())
                .sections(ferme.getSections())
                .utilisateur(UtilisateurDto.fromEntity(ferme.getUtilisateur()))
                .animal(AnimalDto.fromEntity(ferme.getAnimal()))
                .parcelle(ParcelleDto.fromEntity(ferme.getParcelle()))
                .build();

    }

    public static  Ferme toEntity (FermeDto ferme) {

        return Ferme.builder()
                .id(ferme.getId())
                .nom(ferme.getNom())
                .adresse(ferme.getAdresse())
                .surface(ferme.getSurface())
                .sections(ferme.getSections())
                .utilisateur(UtilisateurDto.toEntity(ferme.getUtilisateur()))
                .animal(AnimalDto.toEntity(ferme.getAnimal()))
                .parcelle(ParcelleDto.toEntity(ferme.getParcelle()))
                .build();

    }


}
