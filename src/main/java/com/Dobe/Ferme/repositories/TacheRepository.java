package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Integer> {
}
