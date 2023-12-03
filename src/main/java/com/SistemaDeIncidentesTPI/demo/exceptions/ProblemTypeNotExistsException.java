package com.SistemaDeIncidentesTPI.demo.exceptions;

public class ProblemTypeNotExistsException extends RuntimeException{
    public ProblemTypeNotExistsException (String message){
        super(message);
    }
}
