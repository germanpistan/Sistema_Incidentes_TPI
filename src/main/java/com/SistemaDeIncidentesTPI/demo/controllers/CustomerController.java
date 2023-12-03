package com.SistemaDeIncidentesTPI.demo.controllers;

import com.SistemaDeIncidentesTPI.demo.models.dtos.CustomerDto;
import com.SistemaDeIncidentesTPI.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/customers")
public class CustomerController {
    @Autowired
    private final CustomerService service;

    public CustomerController (CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customer){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.createCustomer(customer));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomers(){
        List<CustomerDto> lista = service.getCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getCustomerById(id));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteCustomer(id));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customer){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateCustomer(id, customer));
    }

}
