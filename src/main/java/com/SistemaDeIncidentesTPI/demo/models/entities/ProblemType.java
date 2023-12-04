package com.SistemaDeIncidentesTPI.demo.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table (name = "tipo_problema")
public class ProblemType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column (name = "descripcion", nullable = false, length = 255)
    private String description;

    @Column (name = "tiempo_estimado", nullable = false)
    private Integer estimatedTime;
}
