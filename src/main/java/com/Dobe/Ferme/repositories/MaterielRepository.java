package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Integer> {
}
