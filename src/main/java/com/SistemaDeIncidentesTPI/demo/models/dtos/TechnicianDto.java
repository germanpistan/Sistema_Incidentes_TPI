package com.SistemaDeIncidentesTPI.demo.models.dtos;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicianDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String preferred_contact_method;
}
