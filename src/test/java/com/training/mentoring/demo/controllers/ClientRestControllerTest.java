package com.training.mentoring.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.mentoring.demo.dto.ContactInfoDto;
import com.training.mentoring.demo.entities.ContactInfoEntity;
import com.training.mentoring.demo.impl.ContactInfoServiceImpl;
import com.training.mentoring.demo.util.MappingObjectsUtil;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClientRestController.class)
@Tag("controller")
public class ClientRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ContactInfoServiceImpl service;

    @Test
    void nuevoEndpoint_shouldReturnDemoMessage() throws Exception {
        mockMvc.perform(get("/contact-book/demo"))
                .andExpect(status().isOk())
                .andExpect(content().string("This is a demo endpoint for testing purposes"));
    }

    @Test
    void getAllContacts_shouldReturnMappedDtos() throws Exception {
        ContactInfoEntity entity = new ContactInfoEntity();
        entity.setEmail("a@b.com");
        when(service.getAllContacts()).thenReturn(List.of(entity));

        ContactInfoDto dto = MappingObjectsUtil.mapEntityToDto.apply(entity);
        mockMvc.perform(get("/contact-book/all-contacts"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(dto))));
    }

    @Test
    void postContact_shouldInvokeServiceSave() throws Exception {
        ContactInfoDto dto = new ContactInfoDto();
        dto.setEmail("c@d.com");
        String json = objectMapper.writeValueAsString(dto);

        mockMvc.perform(post("/contact-book/save-contact")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());

        verify(service).saveContactInfo(Mockito.any(ContactInfoEntity.class));
    }

    @Test
    void deleteContact_shouldReturnServiceResponse() throws Exception {
        when(service.deleteContactByEmail("a@b.com"))
                .thenReturn(ResponseEntity.ok("ok"));

        mockMvc.perform(delete("/contact-book/a@b.com"))
                .andExpect(status().isOk())
                .andExpect(content().string("ok"));
    }
}
