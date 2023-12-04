package com.SistemaDeIncidentesTPI.demo.controllers;


import com.SistemaDeIncidentesTPI.demo.models.dtos.TechnicianDto;

import com.SistemaDeIncidentesTPI.demo.models.entities.Technician;
import com.SistemaDeIncidentesTPI.demo.services.TechnicianService;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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

    public TechnicianController() {

        service = null;
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
    public Technician CrearTecnico() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Technician.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        Technician tecnico = null;

        try {
            tecnico = new Technician(nombre, apellido, dni, email, telefono);
            session.beginTransaction();
            session.persist(tecnico);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

        return tecnico;

    }
    public String VerTécnico (int idtecnico) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Technician.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {

            session.beginTransaction();
            Technician tecnico = session.get(Technician.class, idtecnico);
            session.getTransaction().commit();
            sessionFactory.close();
            return "Técnico ID: " + idtecnico + "| Nombre:"+ tecnico.getName()+" "+ tecnico.getLastName() +"| Correo Electrónico: "+tecnico.getEmail()+"| Teléfono: "+tecnico.getPhone();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Error al leer el técnico";
    }

    public String ActualizarTecnico (int idtecnico, String nombre, String apellido, String email, String telefono) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Technician.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {

            session.beginTransaction();
            Technician tecnico = session.get(Technician.class, idtecnico);
            tecnico.setName(nombre);
            tecnico.setLastName(apellido);
            tecnico.setEmail(email);
            tecnico.setPhone(telefono);

            session.persist(tecnico);
            session.getTransaction().commit();
            sessionFactory.close();
            return "Técnico ID: " + idtecnico + "A sido actualizado con la siguiente información | Nombre:"+ tecnico.getName()+" "+ tecnico.getLastName() +"| Correo Electrónico: "+tecnico.getEmail()+"| Teléfono: "+tecnico.getPhone();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Error al actualizar técnico";

    }

    public String MostrarTodosLosTecnicos() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Technician.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {

            session.beginTransaction();

            CriteriaQuery<Technician> cqry = session.getCriteriaBuilder().createQuery(Technician.class);
            cqry.from(Technician.class);
            List <Technician> tecnico = session.createQuery(cqry).getResultList();
            System.out.println("NUESTROS TÉCNICOS");
            System.out.println("------------------");
            for(Technician i : tecnico) {
                System.out.println("");
                System.out.println("Técnico ID: " + i.getId() + "| Nombre:"+ i.getName()+" "+ i.getLastName() +"| Correo Electrónico: "+i.getEmail()+"| Teléfono: "+i.getPhone());

            }
            sessionFactory.close();
        } catch (Exception exc) {
            exc.printStackTrace();
            return "Error al mostrar los técnicos";
        }
        return "Fin lista de técnicos";
    }
    public String EliminarTecnico(int idtecnico) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Technician.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {

            session.beginTransaction();
            Technician tecnico = session.get(Technician.class, idtecnico);
            session.remove(tecnico);
            session.getTransaction().commit();
            sessionFactory.close();

            return "Técnico Eliminado ID: "+idtecnico;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return "Error al eliminar técnico";

    }

*/


}

