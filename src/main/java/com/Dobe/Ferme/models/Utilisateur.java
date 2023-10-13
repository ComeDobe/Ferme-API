package com.Dobe.Ferme.models;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = " UTILISATEUR ")

public class Utilisateur extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id_Utilisateur;
    private String Nom;
    private String Prenom;
    private String Password;
    private boolean active;
    private String Email;
    private String Adresse;
    private String Telephone;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(name = "ROLE_UTILISATEUR",
                joinColumns = {
                @JoinColumn(name = "ID_UTILISATEUR")
                },
                inverseJoinColumns = {
                @JoinColumn(name = "ID_ROLE")
                }
        )
    private Set<Role> role;

}