package com.projectoconcesionario.concesionario.exception;

public class EmailException extends RuntimeException{
    public EmailException() {
        super("El email no tiene un formato valido");
    }
}
