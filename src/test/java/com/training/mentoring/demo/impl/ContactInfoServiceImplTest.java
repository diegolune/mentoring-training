package com.training.mentoring.demo.impl;

import com.training.mentoring.demo.entities.ContactInfoEntity;
import com.training.mentoring.demo.repositories.ContactInfoRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Tag("service")
public class ContactInfoServiceImplTest {

    @Mock
    private ContactInfoRepository repository;

    @InjectMocks
    private ContactInfoServiceImpl service;

    @Test
    void getContactById_shouldDelegateToRepository() {
        ContactInfoEntity entity = new ContactInfoEntity();
        when(repository.getReferenceById(1L)).thenReturn(entity);

        ContactInfoEntity result = service.getContactById(1L);
        assertSame(entity, result);
        verify(repository).getReferenceById(1L);
    }

    @Test
    void getAllContacts_shouldReturnAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(service.getAllContacts().isEmpty());
        verify(repository).findAll();
    }

    @Test
    void saveContactInfo_shouldCallRepositorySave() {
        ContactInfoEntity entity = new ContactInfoEntity();
        service.saveContactInfo(entity);
        verify(repository).save(entity);
    }

    @Test
    void deleteContactByEmail_whenFound_shouldReturnOk() {
        String email = "a@b.com";
        ContactInfoEntity entity = new ContactInfoEntity();
        when(repository.findByEmail(email)).thenReturn(Optional.of(entity));
        ResponseEntity<String> response = service.deleteContactByEmail(email);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(repository).deleteByEmail(email);
    }

    @Test
    void deleteContactByEmail_whenNotFound_shouldReturnNotFound() {
        String email = "not@found.com";
        when(repository.findByEmail(email)).thenReturn(Optional.empty());
        ResponseEntity<String> response = service.deleteContactByEmail(email);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(repository, never()).deleteByEmail(anyString());
    }
}
