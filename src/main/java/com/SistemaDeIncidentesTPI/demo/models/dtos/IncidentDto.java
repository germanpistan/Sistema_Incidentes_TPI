package com.SistemaDeIncidentesTPI.demo.models.dtos;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidentDto {
    private Long id;
    private String description;
    private Date admissionDate;
    private Date startDate;
    private Date finishDate;
    private Integer totalTime;
    private String observations;
}
