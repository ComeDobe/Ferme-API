package com.Dobe.Ferme.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RoleDto {

    private Integer Id;

    @NotNull(message = "Le roleName ne peut pas etre null")
    @NotEmpty(message = "Le roleName ne peut pas etre vide")
    @NotBlank(message = "Le roleName ne peut pas contenir d'éspace")
    private String NomRole;

    @NotNull(message = "La description ne peut pas etre null")
    @NotEmpty(message = "La description ne peut pas etre vide")
    @NotBlank(message = "La description ne peut pas contenir d'éspace")
    private String DescriptionRole;
}
