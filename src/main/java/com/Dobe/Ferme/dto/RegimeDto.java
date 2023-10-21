package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Animal;
import com.Dobe.Ferme.models.Regime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class RegimeDto {




    private Integer id;
    private Integer quantite;
    private LocalDate dureeRegime;
    private AnimalDto animal;

    public static RegimeDto fromEntity (Regime regime) {
        return RegimeDto.builder()
                .id(regime.getId())
                .quantite(regime.getQuantite())
                .dureeRegime(regime.getDureeRegime())
                .animal(AnimalDto.fromEntity(regime.getAnimal()))
                .build();
    }

    public static Regime toEntity (RegimeDto regime) {

        return Regime.builder()
                .id(regime.getId())
                .quantite(regime.getQuantite())
                .dureeRegime(regime.getDureeRegime())
                .animal(AnimalDto.toEntity(regime.getAnimal()))
                .build();

    }
}
