package com.Dobe.Ferme.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = " MAINTENANCE ")

public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id_Maintenance;
    @Column(name = "Description_Maintenance")
    private String Description;
    @Column(name = "Date_Maintenance")
    private LocalDate Date ;
    @Column(name = "Cout_maintenance")
    private String Cout;

    @ManyToOne
    @JoinColumn(name = "Id_Materiel")
    private Materiel materiel;
    @ManyToOne
    @JoinColumn(name = "Id_Employe")
    private Employe employee;

}
