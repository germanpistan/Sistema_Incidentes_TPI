package com.SistemaDeIncidentesTPI.demo.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table (name = "especialidad")
public class Speciality {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="descripcion",nullable = false, length=255)
    private String description;

    @ManyToOne
    private Technician technician;

}
