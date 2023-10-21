package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Animal;
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
public class AnimalDto {
    private Integer Id;
    private String Nom;
    private String Sexe;
    private String Sante;
    private Integer Poids;
    private Integer tacheId;

    public static AnimalDto fromEntity(Animal animal) {

        return AnimalDto.builder()
                .Id(animal.getId())
                .Nom(animal.getNom())
                .Sexe(animal.getSexe())
                .Sante(animal.getSante())
                .Poids(animal.getPoids())
                .tacheId(animal.getTache().getId())
                .build();
    }
    public static Animal toEntity(Animal animal) {

        Animal animalModel = new Animal();
        animalModel.setId(animal.getId());
        animalModel.setSexe(animal.getSexe());
        animalModel.setSante(animal.getSante());
        animalModel.setPoids(animal.getPoids());

        if (animal.getTache()!= null) {
            Tache tache = new Tache();
            tache.setId(animal.getTache().getId());
            animalModel.setTache(tache);
        }

        return animalModel;
    }

}
