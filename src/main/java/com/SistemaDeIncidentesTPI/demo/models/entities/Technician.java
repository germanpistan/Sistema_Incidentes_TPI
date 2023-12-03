package com.SistemaDeIncidentesTPI.demo.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table (name = "tecnico")
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 45)
    private String name;

    @Column (name = "apellido", length = 45)
    private String lastName;

    @Column (name = "email", length = 45)
    private String email;

    @Column (name = "telefono", length = 45)
    private String phone;

}
