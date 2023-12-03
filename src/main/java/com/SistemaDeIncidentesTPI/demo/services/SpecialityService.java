package com.SistemaDeIncidentesTPI.demo.services;


import com.SistemaDeIncidentesTPI.demo.exceptions.SpecialityNotExistsException;

import com.SistemaDeIncidentesTPI.demo.mappers.SpecialityMapper;

import com.SistemaDeIncidentesTPI.demo.models.dtos.SpecialityDto;

import com.SistemaDeIncidentesTPI.demo.models.entities.Speciality;

import com.SistemaDeIncidentesTPI.demo.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialityService {
    @Autowired
    private SpecialityRepository repository;

    //CREAR ESPECIALIDAD
    public SpecialityDto createSpeciality (SpecialityDto specialityDto){
        Speciality specialityValidated = validateSpecialityById(specialityDto);
        if (specialityValidated == null){
            Speciality specialitySaved = repository.save(SpecialityMapper.dtoToSpeciality(specialityDto));
            return SpecialityMapper.specialityToDto(specialitySaved);
        } else{
            throw new SpecialityNotExistsException("Especialidad con ID: " + specialityDto.getId() + " ya existe");
        }
    }

    //TRAER TODAS LAS ESPECIALIDADES

    public List<SpecialityDto> getSpecialities() {
        List<Speciality> specialities = repository.findAll();
        List<SpecialityDto> specialitiesDtos = specialities.stream()
                .map(SpecialityMapper::specialityToDto)
                .collect(Collectors.toList());
        return specialitiesDtos;
    }

    //TRAER ESPECIALIDAD POR ID

    public SpecialityDto getSpecialityById (Long id){
        Speciality entity = repository.findById(id).get();
        return SpecialityMapper.specialityToDto(entity);
    }

    //ELIMINAR UNA ESPECIALIDAD
    public String deleteSpeciality(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "La especialidad con id: " + id + " ha sido eliminada";
        } else {
            throw new SpecialityNotExistsException("La especialidad a eliminar elegida no existe");
        }
    }

    //ACTUALIZAR UNA ESPECIALIDAD

    public SpecialityDto updateSpeciality(Long id, SpecialityDto dto) {
        if (repository.existsById(id)){
            Speciality specialityToModify = repository.findById(id).get();

            if (dto.getDescription() != null){
                specialityToModify.setDescription(dto.getDescription());
            }

            Speciality specialityModified = repository.save(specialityToModify);

            return SpecialityMapper.specialityToDto(specialityModified);
        }
        return null;
    }

    public Speciality validateSpecialityById(SpecialityDto dto){
        return repository.findById(dto.getId()).get();
    }

}
