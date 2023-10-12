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
@Table(name = " PRODUCTION ")
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Production;

    private String Type;
    private String Qualite;
    private Integer Quantite;
    private LocalDate Date_Production;
    @ManyToOne
    @JoinColumn(name = "Id_Animal")
    private Animal animal;
}
