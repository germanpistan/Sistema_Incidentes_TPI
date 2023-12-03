package com.SistemaDeIncidentesTPI.demo.controllers;

import com.SistemaDeIncidentesTPI.demo.models.dtos.IncidentDto;

import com.SistemaDeIncidentesTPI.demo.services.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {
    @Autowired
    private final IncidentService service;

    public IncidentController(IncidentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<IncidentDto> createIncident(@RequestBody IncidentDto incident){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.createIncident(incident));
    }

    @GetMapping
    public ResponseEntity<List<IncidentDto>> getIncidents(){
        List<IncidentDto> lista = service.getIncidents();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IncidentDto> getIncidentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getIncidentById(id));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deleteIncident(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteIncident(id));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<IncidentDto> updateIncident(@PathVariable Long id, @RequestBody IncidentDto incident){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateIncident(id, incident));
    }


}
