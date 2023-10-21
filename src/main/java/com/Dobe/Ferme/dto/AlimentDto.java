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


    private Integer Id;
    private String Nom;
    private String Type;
    private String Composition;
    private Integer Prix;
    private Integer regimeId;
    public static AlimentDto fromEntity(Aliment aliment) {
        return AlimentDto.builder()
                .Id(aliment.getId())
                .Nom(aliment.getNom())
                .Composition(aliment.getComposition())
                .Prix(aliment.getPrix())
                .Type(aliment.getType())
                .regimeId(aliment.getRegime().getId())
                .build();
    }
    public static Aliment toEntity(AlimentDto aliment) {
        Aliment alimentModel = new Aliment();
        alimentModel.setId(aliment.getId());
        alimentModel.setNom(aliment.getNom());
        alimentModel.setType(aliment.getType());
        alimentModel.setComposition(aliment.getComposition());
        alimentModel.setPrix(aliment.getPrix());

        if (aliment.getRegimeId() != null) {
            Regime regime = new Regime();
            regime.setId(aliment.getRegimeId());
            alimentModel.setRegime(regime);
        }

        return alimentModel;
    }


}
