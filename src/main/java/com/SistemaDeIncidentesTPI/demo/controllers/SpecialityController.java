package com.SistemaDeIncidentesTPI.demo.controllers;


import com.SistemaDeIncidentesTPI.demo.models.dtos.SpecialityDto;

import com.SistemaDeIncidentesTPI.demo.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/especialidades")
public class SpecialityController {
    @Autowired
    private final SpecialityService service;

    public SpecialityController (SpecialityService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SpecialityDto> createSpeciality(@RequestBody SpecialityDto speciality){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.createSpeciality(speciality));
    }

    @GetMapping
    public ResponseEntity<List<SpecialityDto>> getSpecialities(){
        List<SpecialityDto> lista = service.getSpecialities();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SpecialityDto> getSpecialityById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getSpecialityById(id));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deleteSpeciality(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteSpeciality(id));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<SpecialityDto> updateSpeciality(@PathVariable Long id, @RequestBody SpecialityDto speciality){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateSpeciality(id, speciality));
    }
}
