package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.dto.UtilisateurDto;
import com.Dobe.Ferme.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer> {
    @Query("FROM Utilisateur U JOIN FETCH U.role WHERE U.email =:email")
    Optional <Utilisateur> findByEmail(@Param("email") String email);


}
