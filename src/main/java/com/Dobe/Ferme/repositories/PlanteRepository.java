package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Plante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanteRepository extends JpaRepository <Plante, Integer>{
}