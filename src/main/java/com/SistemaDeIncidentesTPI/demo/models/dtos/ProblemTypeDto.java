package com.SistemaDeIncidentesTPI.demo.models.dtos;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProblemTypeDto {
    private long id;
    private String description;
    private Integer estimatedTime;
}
