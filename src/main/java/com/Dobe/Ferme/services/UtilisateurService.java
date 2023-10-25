package com.Dobe.Ferme.services;

import com.Dobe.Ferme.dto.Auth.AuthenticationRequest;
import com.Dobe.Ferme.dto.Auth.AuthenticationResponse;
import com.Dobe.Ferme.dto.UtilisateurDto;

public interface UtilisateurService extends  AbstractService<UtilisateurDto>{

    Integer validateAccount(Integer id);
    Integer invalidateAccount(Integer id);
    Integer registerUtilisateur(Integer id);
    Integer updateUtilisateur(UtilisateurDto utilisateurDto);
    AuthenticationResponse register(UtilisateurDto utilisateurDto);

    AuthenticationResponse authenticate(AuthenticationRequest request);

}
