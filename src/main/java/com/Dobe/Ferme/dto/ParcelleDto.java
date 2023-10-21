package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Parcelle;
import com.Dobe.Ferme.models.Tache;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ParcelleDto {

    private Integer id;
    private String nom;
    private String dimension;
    private String typeSol;
    private TacheDto tache;

    public static ParcelleDto fromEntity(Parcelle parcelle) {
        return ParcelleDto.builder()
                .id(parcelle.getId())
                .nom(parcelle.getNom())
                .dimension(parcelle.getDimension())
                .typeSol(parcelle.getTypeSol())
                .tache(TacheDto.fromEntity((parcelle.getTache())))
                .build();

    }
    public static Parcelle toEntity(ParcelleDto parcelle) {

        return Parcelle.builder()
                .id(parcelle.getId())
                .nom(parcelle.getNom())
                .dimension(parcelle.getDimension())
                .typeSol(parcelle.getTypeSol())
                .tache(TacheDto.toEntity((parcelle.getTache())))
                .build();
    }
}
