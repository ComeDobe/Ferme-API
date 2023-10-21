package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Parcelle;
import com.Dobe.Ferme.models.Plantation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PlantationDto {
    private Integer id;
    private Integer quantitePlantee;
    private ParcelleDto parcelle;

    public static PlantationDto fromEntity(Plantation plantation){
        return PlantationDto.builder()
                .id(plantation.getId())
                .quantitePlantee(plantation.getQuantitePlantee())
                .parcelle(ParcelleDto.fromEntity(plantation.getParcelle()))
                .build();
    }
    public static Plantation toEntity(PlantationDto plantation){
        return Plantation.builder()
                .id(plantation.getId())
                .quantitePlantee(plantation.getQuantitePlantee())
                .parcelle(ParcelleDto.toEntity(plantation.getParcelle()))
                .build();
    }

}
