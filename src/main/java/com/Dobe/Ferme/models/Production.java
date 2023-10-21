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
    private Integer id;

    private String type;
    private String qualite;
    private Integer quantite;
    @Column(name = "Date_Production")
    private LocalDate dateProduction;
    @ManyToOne
    @JoinColumn(name = "Id_Animal")
    private Animal animal;
}
