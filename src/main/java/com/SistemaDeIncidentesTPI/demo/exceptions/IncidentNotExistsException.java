package com.SistemaDeIncidentesTPI.demo.exceptions;

public class IncidentNotExistsException extends  RuntimeException{
    public IncidentNotExistsException (String message){
        super(message);
    }
}
