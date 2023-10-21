package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Animal;
import com.Dobe.Ferme.models.Production;
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
public class ProductionDto {

    private Integer id;
    private String type;
    private String qualite;
    private Integer quantite;
    private LocalDate dateProduction;
    private AnimalDto animal;

    public static ProductionDto fromEntity(Production production) {

        return ProductionDto.builder()
                .id(production.getId())
                .type(production.getType())
                .qualite(production.getQualite())
                .quantite(production.getQuantite())
                .dateProduction(production.getDateProduction())
                .animal(AnimalDto.fromEntity(production.getAnimal()))
                .build();
    }
    public static Production fromEntity(ProductionDto production) {

        return Production.builder()
                .id(production.getId())
                .type(production.getType())
                .qualite(production.getQualite())
                .quantite(production.getQuantite())
                .dateProduction(production.getDateProduction())
                .animal(AnimalDto.toEntity(production.getAnimal()))
                .build();
    }
}
