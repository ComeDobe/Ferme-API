package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT r FROM Role r WHERE r.NomRole = :nomRole")
    Optional<Role> findByNomRole(String nomRole);

}