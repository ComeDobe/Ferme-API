package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Animal;
import com.Dobe.Ferme.models.Espece;
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
public class EspeceDto {


    private Integer id;
    private String nomCommun;
    private String nomScientifique;
    private LocalDate dureeVie;
    private Integer poids;
    private AnimalDto animal;

    public static  EspeceDto fromEntity (Espece espece) {
        return EspeceDto.builder()
                .id(espece.getId())
                .nomCommun(espece.getNomCommun())
                .nomScientifique(espece.getNomScientifique())
                .dureeVie(espece.getDureeVie())
                .poids(espece.getPoids())
                .animal(AnimalDto.fromEntity(espece.getAnimal()))
                .build();
    }
    public static Espece toEntity (EspeceDto espece) {

        return Espece.builder()
                .id(espece.getId())
                .nomCommun(espece.getNomCommun())
                .nomScientifique(espece.getNomScientifique())
                .dureeVie(espece.getDureeVie())
                .poids(espece.getPoids())
                .animal(AnimalDto.toEntity(espece.getAnimal()))
                .build();

    }


}
