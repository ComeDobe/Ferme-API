package com.Dobe.Ferme.models;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = " ROLE ")

public class Role extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Role;

    @Column(name = "Nom_Role")
    private String NomRole;
    @Column(name = "Description_Role")
    private String DescriptionRole;

}