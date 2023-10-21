package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Plantation;
import com.Dobe.Ferme.models.Recolte;
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
public class RecolteDto {

    private Integer id;
   private LocalDate dateRecolte;
    private Integer quantiteProduite;
    private String qualiteProduite;
    private PlantationDto plantation;

    public static  RecolteDto fromEntity (Recolte recolte) {
        return RecolteDto.builder()
                .id(recolte.getId())
                .dateRecolte(recolte.getDateRecolte())
                .quantiteProduite(recolte.getQuantiteProduite())
                .qualiteProduite(recolte.getQualiteProduite())
                .plantation(PlantationDto.fromEntity(recolte.getPlantation()))
                .build();
    }

    public static  Recolte toEntity (RecolteDto recolte) {
        return Recolte.builder()
                .id(recolte.getId())
                .dateRecolte(recolte.getDateRecolte())
                .quantiteProduite(recolte.getQuantiteProduite())
                .qualiteProduite(recolte.getQualiteProduite())
                .plantation(PlantationDto.toEntity(recolte.getPlantation()))
                .build();
    }
}
