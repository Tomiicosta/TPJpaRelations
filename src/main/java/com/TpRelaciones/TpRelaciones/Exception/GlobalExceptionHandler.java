package com.TpRelaciones.TpRelaciones.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarExcepcionesGenerales(Exception ex) {
        // Devuelve 500 si es otra excepción no controlada
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error inesperado: " + ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> ManejarNotFound (NotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
