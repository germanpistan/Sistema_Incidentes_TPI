package com.SistemaDeIncidentesTPI.demo.controllers;


import com.SistemaDeIncidentesTPI.demo.models.dtos.ServiceDto;

import com.SistemaDeIncidentesTPI.demo.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/services")
public class ServiceController {
    @Autowired
    private final ServiceService services;

    public ServiceController(ServiceService services) {
        this.services = services;
    }

    @PostMapping
    public ResponseEntity<ServiceDto> createService(@RequestBody ServiceDto service){
        return  ResponseEntity.status(HttpStatus.CREATED).body(services.createService(service));
    }

    @GetMapping
    public ResponseEntity<List<ServiceDto>> getServices(){
        List<ServiceDto> lista = services.getServices();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServiceDto> getServiceById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(services.getServiceById(id));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deleteService(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(services.deleteService(id));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ServiceDto> updateService(@PathVariable Long id, @RequestBody ServiceDto service){
        return ResponseEntity.status(HttpStatus.OK).body(services.updateService(id, service));
    }
}
