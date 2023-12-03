package com.SistemaDeIncidentesTPI.demo.mappers;


import com.SistemaDeIncidentesTPI.demo.models.dtos.ProblemTypeDto;

import com.SistemaDeIncidentesTPI.demo.models.entities.ProblemType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProblemTypeMapper {
    public ProblemType dtoToProblemType (ProblemTypeDto dto) {
        return ProblemType.builder()
                .description(dto.getDescription())
                .estimatedTime(dto.getEstimatedTime())
                .build();
    }
    public ProblemTypeDto problemTypeToDto (ProblemType problemType){
        return ProblemTypeDto.builder()
                .id(problemType.getId())
                .description(problemType.getDescription())
                .estimatedTime(problemType.getEstimatedTime())
                .build();
    }
}
