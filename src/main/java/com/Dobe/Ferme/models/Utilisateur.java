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

    @Column(name = "Id_Utilisateur")
    private Integer id;
    @Column(name = "Nom")
    private String firstName;
    @Column(name = "Prenom")
    private String lastName;
    private String password;
    private boolean active;
    private String email;
    private String adresse;
    private String telephone;

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