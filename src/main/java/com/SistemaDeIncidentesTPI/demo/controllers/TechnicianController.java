package com.SistemaDeIncidentesTPI.demo.controllers;


import com.SistemaDeIncidentesTPI.demo.mappers.TechnicianMapper;
import com.SistemaDeIncidentesTPI.demo.models.dtos.TechnicianDto;

import com.SistemaDeIncidentesTPI.demo.models.entities.ProblemType;
import com.SistemaDeIncidentesTPI.demo.models.entities.Speciality;
import com.SistemaDeIncidentesTPI.demo.models.entities.Technician;
import com.SistemaDeIncidentesTPI.demo.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    /*
    public void create() {
        Technician newTechnician = new Technician();

        System.out.println("\nSistema de Creacion de Tecnicos, por favor ingrese los datos a continuacion:\n\nDATOS DEL TECNICO.");

        System.out.print("Ingrese el nombre del técnico: ");
        String name = scanner.nextLine();
        newTechnician.setName(name);

        String referred_contact_method;
        while (true) {
            System.out.print("Ingrese el método de contacto preferido:\n1. whatsapp\n2. email\n>_ ");

            int opcion = 0;
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
            }

            if (opcion == 1) {
                referred_contact_method = "whatsapp";
                break;
            } else if (opcion == 2) {
                referred_contact_method = "email";
                break;
            } else {
                System.out.println("!!!Opcion incorrecta, vuelva a intentarlo.");
                scanner.next();
                System.out.println("");
            }
        }
        newTechnician.setPreferred_contact_method(referred_contact_method);

        System.out.println("\nESPECIALIDADES.");
        while (true) {
            Speciality newSpeciality = new Speciality();
            ProblemType newProblemType = new ProblemType();

            System.out.print("Descripcion de la especialidad: ");
            String description = scanner.next();
            newSpeciality.setDescription(description);

            LocalTime max_resolution_time = null;
            while (true) {
                try {
                    System.out.print("Tiempo máximo de resolución en HORAS(Max. 23): ");
                    Integer hours = scanner.nextInt();
                    if (hours < 1 || hours > 23) {
                        throw new Exception();
                    }
                    max_resolution_time = LocalTime.parse("00:00:00", DateTimeFormatter.ISO_LOCAL_TIME).plusHours(hours);
                    System.out.println(max_resolution_time);
                    break;
                } catch (Exception e) {
                    System.out.print("!!!La hora maxima debe ser un numero, entre 1 y 23.\nPresiones ENTER para continuar: ");
                    scanner.nextLine();
                    scanner.nextLine();
                }
            }
            newProblemType.setEstimatedTime(max_resolution_time);

            newTechnician.getSpecialities().add(newSpeciality);

            System.out.print("Se agrego correctamente.\n\nDesea añadir otra especialidad?\n1. SI\n2. NO\n>_ ");
            int opcion = scanner.nextInt();

            System.out.println(newSpeciality);
            if (opcion == 1) {
            } else if (opcion == 2) {
                break;
            } else {
                System.out.println("!!!Opcion incorrecta, intentelo de nuevo");
                scanner.nextLine();
            }
        }


        Technician createdTechnician = this.service.createTechnician(newTechnician);
        System.out.println("TECNICO CREADO: " + createdTechnician);
        System.out.println("ESPECIALIDADES ATRIBUIDAS: " + createdTechnician.getSpecialities());
        System.out.print("El Tecnico Se agrego correctamente.\nPrsione ENTER para continuar. ");
        scanner.nextLine();
        scanner.nextLine();
    }

    public void findAll() {
        System.out.println("Lista de Tecnicos");
        List<Technician> technicians = new ArrayList<>(this.service.findAll());
        for (Technician technician : technicians) {
            System.out.println(technician + " " + technician.getSpecialities());
        }
        System.out.print("Presione ENTER para continuar. ");
        scanner.nextLine();
        scanner.nextLine();
    }

    public void findById() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deleteById() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}*/


}
