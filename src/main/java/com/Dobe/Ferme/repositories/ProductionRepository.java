package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepository extends JpaRepository <Production, Integer>{
}
