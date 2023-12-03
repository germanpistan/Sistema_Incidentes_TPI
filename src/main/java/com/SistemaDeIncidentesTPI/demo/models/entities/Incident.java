package com.SistemaDeIncidentesTPI.demo.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table (name = "incidente")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "descripcion", length =255)
    private String description;

    @Column (name = "fecha_ingreso")
    private Date admissionDate;

    @Column (name = "fecha_inicio")
    private Date startDate;

    @Column (name = "fecha_finalizacion")
    private Date finishDate;

    @Column (name = "tiempo_total", nullable = false)
    private Integer totalTime;

    @Column (name = "observaciones")
    private String observations;


}
