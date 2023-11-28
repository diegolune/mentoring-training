package com.training.mentoring.demo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.mentoring.demo.impl.ContactInfoServiceImpl;
import com.training.mentoring.demo.entities.ContactInfo;
import org.hibernate.collection.spi.PersistentBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contact-book")
public class ClientRestController {

    @Autowired
    private ContactInfoServiceImpl contactInfoService;

    @GetMapping("/demo")
    public ResponseEntity<String> nuevoEndpoint(){

       return ResponseEntity.ok("This is a demo endpoint for testing purposes");
    }

    @GetMapping("/all-contacts")
    public List<ContactInfo> getAllContacts() throws JsonProcessingException {
        return contactInfoService.getAllContacts();
    }

    @PostMapping("/save-contact")
    public void postContactInfo(@RequestBody ContactInfo contactInfo){
        contactInfoService.saveContactInfo(contactInfo);

    }

}
