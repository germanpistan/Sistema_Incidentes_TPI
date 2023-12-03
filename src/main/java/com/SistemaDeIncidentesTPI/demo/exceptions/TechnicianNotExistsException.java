package com.SistemaDeIncidentesTPI.demo.exceptions;

public class TechnicianNotExistsException extends RuntimeException {
    public TechnicianNotExistsException (String message){
        super(message);
    }
}
