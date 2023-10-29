package com.Dobe.Ferme.services;

import com.Dobe.Ferme.dto.Auth.AuthenticationRequest;
import com.Dobe.Ferme.dto.Auth.AuthenticationResponse;
import com.Dobe.Ferme.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService extends  AbstractService<UtilisateurDto>{

    Integer validateAccount(Integer id);
    Integer invalidateAccount(Integer id);
//    Integer registerUtilisateur(Integer id);
//    Integer updateUtilisateur(UtilisateurDto utilisateurDto);
    Integer update(UtilisateurDto utilisateurDto);

    AuthenticationResponse register(UtilisateurDto utilisateurDto);
    AuthenticationResponse authenticate(AuthenticationRequest request);
//    Integer addRole(UtilisateurDto utilisateurDto);

}
