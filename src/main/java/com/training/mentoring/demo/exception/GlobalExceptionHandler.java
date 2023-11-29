package com.training.mentoring.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeExeption(RuntimeException exception){
        return new ResponseEntity<>("Internal Server Error xxx: " + exception.getMessage()+ " Class: " + exception.getClass() , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
