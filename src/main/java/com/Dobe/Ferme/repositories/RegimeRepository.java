package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Regime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegimeRepository extends JpaRepository <Regime, Integer>{
}
