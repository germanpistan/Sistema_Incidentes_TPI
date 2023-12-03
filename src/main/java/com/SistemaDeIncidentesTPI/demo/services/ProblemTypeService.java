package com.SistemaDeIncidentesTPI.demo.services;


import com.SistemaDeIncidentesTPI.demo.exceptions.ProblemTypeNotExistsException;

import com.SistemaDeIncidentesTPI.demo.mappers.ProblemTypeMapper;

import com.SistemaDeIncidentesTPI.demo.models.dtos.ProblemTypeDto;

import com.SistemaDeIncidentesTPI.demo.models.entities.ProblemType;
import com.SistemaDeIncidentesTPI.demo.repositories.ProblemTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProblemTypeService {
    @Autowired
    private ProblemTypeRepository repository;

    //CREAR TIPO DE PROBLEMA
    public ProblemTypeDto createProblemType (ProblemTypeDto problemTypeDto){
        ProblemType problemTypeValidated = validateProblemTypeById(problemTypeDto);
        if (problemTypeValidated == null){
            ProblemType problemTypeSaved = repository.save(ProblemTypeMapper.dtoToProblemType(problemTypeDto));
            return ProblemTypeMapper.problemTypeToDto(problemTypeSaved);
        } else{
            throw new ProblemTypeNotExistsException("Tipo de problema con ID: " + problemTypeDto.getId() + " ya existe");
        }
    }

    //TRAER TODOS LOS PROBLEMAS

    public List<ProblemTypeDto> getProblemTypes() {
        List<ProblemType> problemTypes = repository.findAll();
        List<ProblemTypeDto> problemTypesDtos = problemTypes.stream()
                .map(ProblemTypeMapper::problemTypeToDto)
                .collect(Collectors.toList());
        return problemTypesDtos;
    }

    //TRAER PROBLEMA POR ID

    public ProblemTypeDto getProblemTypeById (Long id){
        ProblemType entity = repository.findById(id).get();
        return ProblemTypeMapper.problemTypeToDto(entity);
    }

    //ELIMINAR UN PROBLEMA
    public String deleteProblemType(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "El tipo de problema con id: " + id + " ha sido eliminado";
        } else {
            throw new ProblemTypeNotExistsException("El tipo de problema a eliminar elegido no existe");
        }
    }

    //ACTUALIZAR UN PROBLEMA

    public ProblemTypeDto updateProblemType(Long id, ProblemTypeDto dto) {
        if (repository.existsById(id)){
            ProblemType problemTypeToModify = repository.findById(id).get();

            if (dto.getDescription() != null){
                problemTypeToModify.setDescription(dto.getDescription());
            }

            if (dto.getEstimatedTime() != null){
                problemTypeToModify.setEstimatedTime(dto.getEstimatedTime());
            }

            ProblemType problemTypeModified = repository.save(problemTypeToModify);

            return ProblemTypeMapper.problemTypeToDto(problemTypeModified);
        }
        return null;
    }

    public ProblemType validateProblemTypeById(ProblemTypeDto dto){
        return repository.findById(dto.getId()).get();
    }
}
