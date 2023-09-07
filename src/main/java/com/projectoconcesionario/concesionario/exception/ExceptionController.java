package com.projectoconcesionario.concesionario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<Map<String,String>> emailException(EmailException emailException){
        Map<String,String> response=new HashMap<>();
        response.put("error",emailException.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

}
