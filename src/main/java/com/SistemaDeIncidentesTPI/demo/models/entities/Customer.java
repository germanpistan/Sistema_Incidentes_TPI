package com.SistemaDeIncidentesTPI.demo.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table (name = "cliente")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre", nullable = false, length = 45)
    private String name;

    @Column (name = "apellido", nullable = false, length = 45)
    private String lastName;

    @Column (name = "email", nullable = false, length = 45)
    private String email;
    @Column (name = "razon_social", nullable = false, length = 255)
    private String businessName;

    @Column (name = "CUIT", nullable = false, length = 20)
    private String cuit;
}
