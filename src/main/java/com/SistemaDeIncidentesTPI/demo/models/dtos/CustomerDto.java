package com.SistemaDeIncidentesTPI.demo.models.dtos;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String businessName;
    private String cuit;
}
