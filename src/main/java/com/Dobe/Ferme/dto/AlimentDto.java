package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Aliment;
import com.Dobe.Ferme.models.Regime;
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
public class AlimentDto {


    private Integer id;
    private String nom;
    private String type;
    private String composition;
    private Integer prix;
    private RegimeDto regime;
    public static AlimentDto fromEntity(Aliment aliment) {
        return AlimentDto.builder()
                .id(aliment.getId())
                .nom(aliment.getNom())
                .composition(aliment.getComposition())
                .prix(aliment.getPrix())
                .type(aliment.getType())
                .regime(RegimeDto.fromEntity(aliment.getRegime()))
                .build();
    }
    public static Aliment toEntity(AlimentDto aliment) {
        return Aliment.builder()
                .id(aliment.getId())
                .nom(aliment.getNom())
                .composition(aliment.getComposition())
                .prix(aliment.getPrix())
                .type(aliment.getType())
                .regime(RegimeDto.toEntity(aliment.getRegime()))
                .build();

    }


}
