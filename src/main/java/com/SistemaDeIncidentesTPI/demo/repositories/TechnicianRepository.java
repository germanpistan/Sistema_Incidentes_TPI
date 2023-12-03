package com.SistemaDeIncidentesTPI.demo.repositories;

import com.SistemaDeIncidentesTPI.demo.models.entities.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
}
