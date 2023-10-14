package com.Dobe.Ferme.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = " PRODUCTION ")
public class Production extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id_Production")
    private Integer Id;

    private String Type;
    private String Qualite;
    private Integer Quantite;
    @Column(name = "Date_Production")
    private LocalDate DateProduction;
    @ManyToOne
    @JoinColumn(name = "Id_Animal")
    private Animal animal;
}
