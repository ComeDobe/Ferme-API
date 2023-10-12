package com.Dobe.Ferme.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = " ROLE ")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Role;
    private String Nom_Role;
    private String Description_Role;

}