package com.SistemaDeIncidentesTPI.demo.mappers;



import com.SistemaDeIncidentesTPI.demo.models.dtos.IncidentDto;

import com.SistemaDeIncidentesTPI.demo.models.entities.Incident;
import lombok.experimental.UtilityClass;

@UtilityClass
public class IncidentMapper {
    public Incident dtoToIncident (IncidentDto dto) {
        return Incident.builder()
                .description(dto.getDescription())
                .admissionDate(dto.getAdmissionDate())
                .startDate(dto.getStartDate())
                .finishDate(dto.getFinishDate())
                .totalTime(dto.getTotalTime())
                .observations(dto.getObservations())
                .build();
    }

    public IncidentDto incidentToDto (Incident incident){
        return IncidentDto.builder()
                .id(incident.getId())
                .description(incident.getDescription())
                .admissionDate(incident.getAdmissionDate())
                .startDate(incident.getStartDate())
                .finishDate(incident.getFinishDate())
                .totalTime(incident.getTotalTime())
                .observations(incident.getObservations())
                .build();
    }
}
