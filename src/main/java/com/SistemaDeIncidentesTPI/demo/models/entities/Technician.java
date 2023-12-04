package com.SistemaDeIncidentesTPI.demo.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @Column(name = "nombre", nullable = false, length = 45)
    private String name;

    @Column (name = "apellido", length = 45)
    private String lastName;

    @Column (name = "email", length = 45)
    private String email;

    @Column (name = "telefono", length = 45)
    private String phone;

    @OneToMany(mappedBy = "technician", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Speciality> specialities;

    @OneToMany(mappedBy = "technician", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <Incident> incidents;



}
