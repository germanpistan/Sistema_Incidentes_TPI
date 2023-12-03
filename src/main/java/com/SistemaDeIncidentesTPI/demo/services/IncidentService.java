package com.SistemaDeIncidentesTPI.demo.services;


import com.SistemaDeIncidentesTPI.demo.exceptions.IncidentNotExistsException;

import com.SistemaDeIncidentesTPI.demo.mappers.IncidentMapper;

import com.SistemaDeIncidentesTPI.demo.models.dtos.IncidentDto;

import com.SistemaDeIncidentesTPI.demo.models.entities.Incident;
import com.SistemaDeIncidentesTPI.demo.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository repository;


    //CREAR INCIDENTE
    public IncidentDto createIncident (IncidentDto incidentDto){
        Incident incidentValidated = validateIncidentById(incidentDto);
        if (incidentValidated == null){
            Incident incidentSaved = repository.save(IncidentMapper.dtoToIncident(incidentDto));
            return IncidentMapper.incidentToDto(incidentSaved);
        } else{
            throw new IncidentNotExistsException("Incidente con el ID: " + incidentDto.getId() + " ya existe");
        }
    }

    //TRAER TODOS LOS INCIDENTES
    public List<IncidentDto> getIncidents() {
        List<Incident> incidents = repository.findAll();
        List<IncidentDto> indicentsDtos = incidents.stream()
                .map(IncidentMapper::incidentToDto)
                .collect(Collectors.toList());
        return indicentsDtos;
    }

    //TRAER INCIDENT POR ID

    public IncidentDto getIncidentById (Long id){
        Incident entity = repository.findById(id).get();
        return IncidentMapper.incidentToDto(entity);
    }

    //ELIMINAR UN INCIDENTE
    public String deleteIncident(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "El incidente con id: " + id + " ha sido eliminado";
        } else {
            throw new IncidentNotExistsException("El incidente a eliminar elegido no existe");
        }
    }

    //ACTUALIZAR UN INCIDENTE

    public IncidentDto updateIncident(Long id, IncidentDto dto) {
        if (repository.existsById(id)){
            Incident incidentToModify = repository.findById(id).get();

            if (dto.getDescription() != null){
                incidentToModify.setDescription(dto.getDescription());
            }

            if (dto.getStartDate() != null){
                incidentToModify.setStartDate(dto.getStartDate());
            }

            if (dto.getFinishDate() != null){
                incidentToModify.setFinishDate(dto.getFinishDate());
            }

            if (dto.getTotalTime() != null){
                incidentToModify.setTotalTime(dto.getTotalTime());
            }

            if (dto.getObservations() != null){
                incidentToModify.setObservations(dto.getObservations());
            }

            Incident incidentModified = repository.save(incidentToModify);

            return IncidentMapper.incidentToDto(incidentModified);
        }
        return null;
    }

    public Incident validateIncidentById(IncidentDto dto){
        return repository.findById(dto.getId()).get();
    }

}
