package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository <Animal, Integer>{
}
