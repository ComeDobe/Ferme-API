package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Parcelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelleRepository extends JpaRepository <Parcelle, Integer>{
}
