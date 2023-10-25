package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Aliment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentRepository extends JpaRepository<Aliment, Integer> {
}
