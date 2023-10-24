package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Recolte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecolteRepository extends JpaRepository<Recolte, Integer> {
}
