package com.SistemaDeIncidentesTPI.demo.mappers;


import com.SistemaDeIncidentesTPI.demo.models.dtos.SpecialityDto;

import com.SistemaDeIncidentesTPI.demo.models.entities.Speciality;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SpecialityMapper {
    public Speciality dtoToSpeciality (SpecialityDto dto) {
        return Speciality.builder()
                .description(dto.getDescription())
                .build();
    }
    public SpecialityDto specialityToDto (Speciality speciality){
        return SpecialityDto.builder()
                .id(speciality.getId())
                .description(speciality.getDescription())
                .build();
    }
}
