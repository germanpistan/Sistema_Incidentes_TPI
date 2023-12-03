package com.SistemaDeIncidentesTPI.demo.controllers;

import com.SistemaDeIncidentesTPI.demo.models.dtos.CustomerDto;
import com.SistemaDeIncidentesTPI.demo.models.dtos.ProblemTypeDto;
import com.SistemaDeIncidentesTPI.demo.services.ProblemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/problems")
public class ProblemTypeController {
    @Autowired
    private final ProblemTypeService service;

    public ProblemTypeController(ProblemTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProblemTypeDto> createProblemType(@RequestBody ProblemTypeDto problemType){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.createProblemType(problemType));
    }

    @GetMapping
    public ResponseEntity<List<ProblemTypeDto>> getProblemTypes(){
        List<ProblemTypeDto> lista = service.getProblemTypes();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProblemTypeDto> getProblemTypeById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getProblemTypeById(id));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deleteProblemType(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteProblemType(id));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ProblemTypeDto> updateProblemType(@PathVariable Long id, @RequestBody ProblemTypeDto problemType){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateProblemType(id, problemType));
    }

}
