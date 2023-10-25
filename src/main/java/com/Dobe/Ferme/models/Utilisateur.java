package com.Dobe.Ferme.models;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = " UTILISATEUR ")

public class Utilisateur extends AbstractEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id_Utilisateur")
    private Integer id;

    @Column(unique = true)
    private String firstName;

    private String lastName;
    @Column(unique = true)
    private String password;
    private boolean active;
    @Column(unique = true)
    private String email;
    private String adresse;
    private String telephone;
    private boolean isAdmin;
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





//-----------------------------------------------------------------------------------------------------------------
//    Userdetails
//-----------------------------------------------------------------------------------------------------------------


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }


    public void addRole(Role role) {
        if (this.role == null) {
            this.role = new HashSet<>();
        }
        this.role.add(role);
    }

}