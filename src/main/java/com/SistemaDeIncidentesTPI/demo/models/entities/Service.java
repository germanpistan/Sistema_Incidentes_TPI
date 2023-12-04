package com.SistemaDeIncidentesTPI.demo.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table (name = "servicio")
public class Service {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column (name="nombre",nullable = false, length=255)
    private String name;

    @ManyToOne
    private Customer customer;


}
