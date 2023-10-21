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

    private Integer Id;

    @NotBlank(message = "le nom ne doit pas être vide")
    private String FirstName;

    @NotBlank(message = "le prénom ne doit pas être vide")
    private String LastName;

    @NotBlank(message = "le mot de passe ne doit pas être vide")
    @Size(min = 8, max = 16, message = "le mot de passe doit être entre 8 et 16 caractères")
    private String Password;

    @NotBlank(message = "L'email ne doit pas être vide")
    @Email(message = "L'email n'est pas conforme")
    private String Email;

    @NotBlank(message = "l'adresse ne doit pas être vide")
    private String Adresse;

    @NotBlank(message = "le téléphone ne doit pas être vide")
    private String Telephone;

    private boolean active;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        return UtilisateurDto.builder()
                .Id(utilisateur.getId())
                .FirstName(utilisateur.getFirstName())
                .LastName(utilisateur.getLastName())
                .Email(utilisateur.getEmail())
                .Telephone(utilisateur.getTelephone())
                .Adresse(utilisateur.getAdresse())
                .active(utilisateur.isActive())
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateur) {
        return Utilisateur.builder()
                .Id(utilisateur.getId())
                .FirstName(utilisateur.getFirstName())
                .LastName(utilisateur.getLastName())
                .Email(utilisateur.getEmail())
                .Telephone(utilisateur.getTelephone())
                .Adresse(utilisateur.getAdresse())
                .Password(utilisateur.getPassword())
                .build();
    }
}