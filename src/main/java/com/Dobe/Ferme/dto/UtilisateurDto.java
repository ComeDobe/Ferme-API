package com.Dobe.Ferme.dto;

import com.Dobe.Ferme.models.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UtilisateurDto {

    private Integer id;

    @NotBlank(message = "le nom ne doit pas être vide")
    private String firstName;

    @NotBlank(message = "le prénom ne doit pas être vide")
    private String lastName;

    @NotBlank(message = "le mot de passe ne doit pas être vide")
    @Size(min = 8, max = 16, message = "le mot de passe doit être entre 8 et 16 caractères")
    private String password;

    @NotBlank(message = "L'email ne doit pas être vide")
    @Email(message = "L'email n'est pas conforme")
    private String email;

    @NotBlank(message = "l'adresse ne doit pas être vide")
    private String adresse;

    @NotBlank(message = "le téléphone ne doit pas être vide")
    private String telephone;

    private boolean active;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .firstName(utilisateur.getFirstName())
                .lastName(utilisateur.getLastName())
                .email(utilisateur.getEmail())
                .telephone(utilisateur.getTelephone())
                .adresse(utilisateur.getAdresse())
                .password(utilisateur.getPassword())
                .active(utilisateur.isActive())
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateur) {
        return Utilisateur.builder()
                .id(utilisateur.getId())
                .firstName(utilisateur.getFirstName())
                .lastName(utilisateur.getLastName())
                .email(utilisateur.getEmail())
                .telephone(utilisateur.getTelephone())
                .adresse(utilisateur.getAdresse())
                .password(utilisateur.getPassword())
                .active(utilisateur.isActive())
                .build();
    }
}