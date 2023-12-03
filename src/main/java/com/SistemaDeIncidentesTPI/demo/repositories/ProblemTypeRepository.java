package com.SistemaDeIncidentesTPI.demo.repositories;

import com.SistemaDeIncidentesTPI.demo.models.entities.ProblemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemTypeRepository extends JpaRepository<ProblemType, Long> {
}
