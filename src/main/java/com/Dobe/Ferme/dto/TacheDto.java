
package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Tache;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TacheDto {
    private Integer id;
    private String description;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public static TacheDto fromEntity(Tache tache) {
        return TacheDto.builder()
                .id(tache.getId())
                .description(tache.getDescription())
                .dateDebut(tache.getDateDebut())
                .dateFin(tache.getDateFin())
                .build();

    }

    public static Tache toEntity(TacheDto tache) {

        return Tache.builder()
                .id(tache.getId())
                .description(tache.getDescription())
                .dateDebut(tache.getDateDebut())
                .dateFin(tache.getDateFin())
                .build();
    }
}
