package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Animal;
import com.Dobe.Ferme.models.Tache;
import com.Dobe.Ferme.repositories.TacheRepository;
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
    private Integer id;
    private String nom;
    private String sexe;
    private String sante;
    private Integer poids;
    private TacheDto tache;

    public static AnimalDto fromEntity(Animal animal) {

        return AnimalDto.builder()
                .id(animal.getId())
                .nom(animal.getNom())
                .sexe(animal.getSexe())
                .sante(animal.getSante())
                .poids(animal.getPoids())
                .tache(TacheDto.fromEntity(animal.getTache()))
                .build();
    }
    public static Animal toEntity(AnimalDto animal) {

        return Animal.builder()
                .id(animal.getId())
                .nom(animal.getNom())
                .sexe(animal.getSexe())
                .sante(animal.getSante())
                .poids(animal.getPoids())
                .tache(TacheDto.toEntity(animal.getTache()))
                .build();
    }

}
