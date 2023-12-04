package com.SistemaDeIncidentesTPI.demo.repositories;

import com.SistemaDeIncidentesTPI.demo.models.entities.Incident;
import com.SistemaDeIncidentesTPI.demo.models.entities.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository <Incident, Long> {
    Incident findByTotalTime (Integer totalTime);


}
