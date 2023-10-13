package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Aliment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlimentRepository extends JpaRepository<Aliment, Integer> {
}
