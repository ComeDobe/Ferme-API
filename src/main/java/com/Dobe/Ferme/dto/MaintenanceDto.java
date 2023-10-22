package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Employe;
import com.Dobe.Ferme.models.Maintenance;
import com.Dobe.Ferme.models.Materiel;
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
public class MaintenanceDto {

    private Integer id;
    private String description;
    private LocalDate date ;
    private String cout;
    private MaterielDto materiel;
    private EmployeDto employe;

    public static MaintenanceDto fromEntity(Maintenance maintenance){
        return MaintenanceDto.builder()
                .id(maintenance.getId())
                .description(maintenance.getDescription())
                .date(maintenance.getDate())
                .cout(maintenance.getCout())
                .employe(EmployeDto.fromEntity(maintenance.getEmploye()))
                .materiel(MaterielDto.fromEntity(maintenance.getMateriel()))
                .build();
    }

    public static Maintenance toEntity(MaintenanceDto maintenance){
        return Maintenance.builder()
                .id(maintenance.getId())
                .description(maintenance.getDescription())
                .date(maintenance.getDate())
                .cout(maintenance.getCout())
                .employe(EmployeDto.toEntity(maintenance.getEmploye()))
                .materiel(MaterielDto.toEntity(maintenance.getMateriel()))
                .build();

    }
}
