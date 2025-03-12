package com.example.EsercizioGestionProdottiREST.exceptions;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<String> manageEntityExistsException(EntityExistsException e) {
        return new ResponseEntity<String>(e.getMessage() + " EntityExistsException!!!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> manageDataIntegrityViolationException(DataIntegrityViolationException e) {
        return new ResponseEntity<String>(e.getMessage() + " DataIntegrityViolationException!!!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> manageEntityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<String>(e.getMessage() + " EntityNotFoundException!!!", HttpStatus.BAD_REQUEST);
    }

}
