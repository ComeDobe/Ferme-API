package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache, Integer> {
}
