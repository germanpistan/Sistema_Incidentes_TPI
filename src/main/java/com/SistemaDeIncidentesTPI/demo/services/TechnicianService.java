package com.SistemaDeIncidentesTPI.demo.services;


import com.SistemaDeIncidentesTPI.demo.exceptions.TechnicianNotExistsException;

import com.SistemaDeIncidentesTPI.demo.mappers.TechnicianMapper;

import com.SistemaDeIncidentesTPI.demo.models.dtos.TechnicianDto;

import com.SistemaDeIncidentesTPI.demo.models.entities.Technician;

import com.SistemaDeIncidentesTPI.demo.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TechnicianService {
    @Autowired
    private TechnicianRepository repository;

    //CREAR TECNICO
    public TechnicianDto createTechnician (TechnicianDto technicianDto){
        Technician technicianValidated = validateTechnicianByName(technicianDto);
        if (technicianValidated == null){
            Technician technicianSaved = repository.save(TechnicianMapper.dtoToTechnician(technicianDto));
            return TechnicianMapper.technicianToDto(technicianSaved);
        } else{
            throw new TechnicianNotExistsException("Cliente con nombre: " + technicianDto.getName() + " no puede ser creado");
        }
    }

    //TRAER TODOS LOS TECNICOS

    public List<TechnicianDto> getTechnicians() {
        List<Technician> technicians = repository.findAll();
        List<TechnicianDto> techniciansDtos = technicians.stream()
                .map(TechnicianMapper::technicianToDto)
                .collect(Collectors.toList());
        return techniciansDtos;
    }

    //TRAER TECNICO POR ID

    public TechnicianDto getTechnicianById (Long id){
        Technician entity = repository.findById(id).get();
        return TechnicianMapper.technicianToDto(entity);
    }

    //ELIMINAR UN TECNICO
    public String deleteTechnician(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "El cliente con id: " + id + " ha sido eliminado";
        } else {
            throw new TechnicianNotExistsException("El cliente a eliminar elegido no existe");
        }
    }

    //ACTUALIZAR UN TECNICO

    public TechnicianDto updateTechnician(Long id, TechnicianDto dto) {
        if (repository.existsById(id)){
            Technician technicianToModify = repository.findById(id).get();

            if (dto.getName() != null){
                technicianToModify.setName(dto.getName());
            }

            if (dto.getLastName() != null){
                technicianToModify.setLastName(dto.getLastName());
            }

            if (dto.getEmail() != null){
                technicianToModify.setEmail(dto.getEmail());
            }

            if (dto.getPhone() != null){
                technicianToModify.setPhone(dto.getPhone());
            }


            Technician technicianModified = repository.save(technicianToModify);

            return TechnicianMapper.technicianToDto(technicianModified);
        }
        return null;
    }





    public Technician validateTechnicianByName(TechnicianDto dto){
        return repository.findByName(dto.getName());
    }
}
