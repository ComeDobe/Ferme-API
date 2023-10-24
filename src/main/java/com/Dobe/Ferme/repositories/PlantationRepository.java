package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Plantation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantationRepository extends JpaRepository <Plantation, Integer>{
}
