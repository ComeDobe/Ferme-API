package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Plantation;
import com.Dobe.Ferme.models.Plante;
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
public class PlanteDto {
    private Integer  id;
    private String nom;
    private String pseudo;
    private String climent;
    private String sol;
    private PlantationDto plantation;

    public static PlanteDto fromEntity(Plante plante) {
        return PlanteDto.builder()
                .id(plante.getId())
                .nom(plante.getNom())
                .pseudo(plante.getPseudo())
                .climent(plante.getCliment())
                .sol(plante.getCliment())
                .plantation(PlantationDto.fromEntity(plante.getPlantation()))
                .build();
    }
    public static Plante toEntity(PlanteDto plante) {
        return Plante.builder()
                .id(plante.getId())
                .nom(plante.getNom())
                .pseudo(plante.getPseudo())
                .climent(plante.getCliment())
                .sol(plante.getCliment())
                .plantation(PlantationDto.toEntity(plante.getPlantation()))
                .build();

    }
}
