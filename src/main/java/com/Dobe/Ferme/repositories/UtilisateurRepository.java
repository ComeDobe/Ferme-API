package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer> {
    @Query("FROM Utilisateur U JOIN FETCH U.role WHERE U.Email =:email")
    Optional <Utilisateur> findByEmail(@Param("email") String email);
}
