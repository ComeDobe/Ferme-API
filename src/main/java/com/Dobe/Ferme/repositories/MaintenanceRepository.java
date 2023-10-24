package com.Dobe.Ferme.repositories;

import com.Dobe.Ferme.models.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer>{
}
