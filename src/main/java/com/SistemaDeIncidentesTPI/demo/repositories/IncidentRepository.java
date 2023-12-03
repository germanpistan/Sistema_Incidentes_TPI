package com.SistemaDeIncidentesTPI.demo.repositories;

import com.SistemaDeIncidentesTPI.demo.models.entities.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository <Incident, Long> {
}
