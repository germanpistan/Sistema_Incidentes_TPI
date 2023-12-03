package com.SistemaDeIncidentesTPI.demo.mappers;


import com.SistemaDeIncidentesTPI.demo.models.dtos.TechnicianDto;

import com.SistemaDeIncidentesTPI.demo.models.entities.Technician;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TechnicianMapper {
    public Technician dtoToTechnician (TechnicianDto dto) {
        return Technician.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();
    }
    public TechnicianDto technicianToDto(Technician technician) {
        return TechnicianDto.builder()
                .id(technician.getId())
                .name(technician.getName())
                .lastName(technician.getLastName())
                .email(technician.getEmail())
                .phone(technician.getPhone())
                .build();
    }
}
