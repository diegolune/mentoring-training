package com.training.mentoring.demo.exception;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@Tag("exception")
public class GlobalExceptionHandlerTest {

    @Test
    void handleRuntimeException_shouldReturn500() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        RuntimeException ex = new RuntimeException("boom");
        ResponseEntity<String> response = handler.handleRuntimeExeption(ex);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertTrue(response.getBody().contains("boom"));
    }
}
