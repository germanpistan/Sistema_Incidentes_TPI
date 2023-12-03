package com.SistemaDeIncidentesTPI.demo.mappers;


import com.SistemaDeIncidentesTPI.demo.models.dtos.ServiceDto;

import com.SistemaDeIncidentesTPI.demo.models.entities.Service;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ServiceMapper {
    public Service dtoToService (ServiceDto dto) {
        return Service.builder()
                .name(dto.getName())
                .build();
    }
    public ServiceDto serviceToDto (Service service){
        return ServiceDto.builder()
                .id(service.getId())
                .name(service.getName())
                .build();
    }
}
