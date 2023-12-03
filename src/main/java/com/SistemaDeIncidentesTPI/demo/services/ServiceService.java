package com.SistemaDeIncidentesTPI.demo.services;


import com.SistemaDeIncidentesTPI.demo.exceptions.ProblemTypeNotExistsException;
import com.SistemaDeIncidentesTPI.demo.exceptions.ServiceNotExistsException;
import com.SistemaDeIncidentesTPI.demo.mappers.ProblemTypeMapper;
import com.SistemaDeIncidentesTPI.demo.mappers.ServiceMapper;

import com.SistemaDeIncidentesTPI.demo.models.dtos.ProblemTypeDto;
import com.SistemaDeIncidentesTPI.demo.models.dtos.ServiceDto;
import com.SistemaDeIncidentesTPI.demo.models.entities.ProblemType;
import com.SistemaDeIncidentesTPI.demo.models.entities.Service;


import com.SistemaDeIncidentesTPI.demo.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;


@org.springframework.stereotype.Service
public class ServiceService {
    @Autowired
    private ServiceRepository repository;

    //CREAR SERVICIO
    public ServiceDto createService (ServiceDto serviceDto){
        Service serviceValidated = validateServiceById(serviceDto);
        if (serviceValidated == null){
             Service serviceSaved = repository.save(ServiceMapper.dtoToService(serviceDto));
            return ServiceMapper.serviceToDto(serviceSaved);
        } else{
            throw new ServiceNotExistsException("Tipo de servicio con ID: " + serviceDto.getId() + " ya existe");
        }
    }

    //TRAER TODOS LOS SERVICIOS

    public List<ServiceDto> getServices() {
        List<Service> services = repository.findAll();
        List<ServiceDto> servicesDtos = services.stream()
                .map(ServiceMapper::serviceToDto)
                .collect(Collectors.toList());
        return servicesDtos;
    }

    //TRAER SERVICIO POR ID

    public ServiceDto getServiceById (Long id){
        Service entity = repository.findById(id).get();
        return ServiceMapper.serviceToDto(entity);
    }

    //ELIMINAR UN SERVICIO
    public String deleteService(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "El servicio con id: " + id + " ha sido eliminado";
        } else {
            throw new ServiceNotExistsException("El servicio a eliminar elegido no existe");
        }
    }

    //ACTUALIZAR UN SERVICIO

    public ServiceDto updateService(Long id, ServiceDto dto) {
        if (repository.existsById(id)){
            Service serviceToModify = repository.findById(id).get();

            if (dto.getName() != null){
                serviceToModify.setName(dto.getName());
            }

            Service serviceModified = repository.save(serviceToModify);

            return ServiceMapper.serviceToDto(serviceModified);
        }
        return null;
    }

    public Service validateServiceById(ServiceDto dto){
        return repository.findById(dto.getId()).get();
    }
}
