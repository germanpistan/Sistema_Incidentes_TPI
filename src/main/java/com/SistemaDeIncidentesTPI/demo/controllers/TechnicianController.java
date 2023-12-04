package com.SistemaDeIncidentesTPI.demo.controllers;


import com.SistemaDeIncidentesTPI.demo.models.dtos.TechnicianDto;

import com.SistemaDeIncidentesTPI.demo.models.entities.Technician;
import com.SistemaDeIncidentesTPI.demo.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technicians")
public class TechnicianController {
    @Autowired
    private final TechnicianService service;

    public TechnicianController (TechnicianService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TechnicianDto> createTechnician(@RequestBody TechnicianDto technician){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.createTechnician(technician));
    }

    @GetMapping
    public ResponseEntity<List<TechnicianDto>> getTechnicians(){
        List<TechnicianDto> lista = service.getTechnicians();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnicianDto> getTechnicianById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getTechnicianById(id));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deleteTechnician(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteTechnician(id));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<TechnicianDto> updateTechnician(@PathVariable Long id, @RequestBody TechnicianDto technician){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateTechnician(id, technician));
    }


}
