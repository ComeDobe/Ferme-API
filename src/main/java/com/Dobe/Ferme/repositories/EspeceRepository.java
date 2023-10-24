package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Espece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspeceRepository extends JpaRepository <Espece, Integer>{
}
