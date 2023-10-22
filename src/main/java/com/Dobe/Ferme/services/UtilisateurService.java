package com.Dobe.Ferme.services;

import com.Dobe.Ferme.dto.UtilisateurDto;

public interface UtilisateurService extends  AbstractService<UtilisateurDto>{

    Integer validateAccount(Integer id);
    Integer invalidateAccount(Integer id);

}
