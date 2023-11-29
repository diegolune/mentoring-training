package com.training.mentoring.demo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.mentoring.demo.dto.ContactInfoDto;
import com.training.mentoring.demo.entities.ContactInfoEntity;
import com.training.mentoring.demo.impl.ContactInfoServiceImpl;
import com.training.mentoring.demo.util.MappingObjectsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contact-book")
public class ClientRestController {

    @Autowired
    private ContactInfoServiceImpl contactInfoService;

    @GetMapping("/demo")
    public ResponseEntity<String> nuevoEndpoint() {

        return ResponseEntity.ok("This is a demo endpoint for testing purposes");
    }

    @GetMapping("/all-contacts")
    public List<ContactInfoDto> getAllContacts() throws JsonProcessingException {
        List<ContactInfoEntity> aListOfEntityContacts = contactInfoService.getAllContacts();
        List<ContactInfoDto> aListOfDtoContacts = aListOfEntityContacts.stream().map(usuario -> MappingObjectsUtil.mapEntityToDto.apply(usuario)).collect(Collectors.toList());
        return aListOfDtoContacts;
    }

    @PostMapping("/save-contact")
    public void postContactInfo(@RequestBody ContactInfoDto contactInfo) {
        ContactInfoEntity  contactInfoRequested = MappingObjectsUtil.mapDtoToEntity.apply(contactInfo);
        contactInfoService.saveContactInfo(contactInfoRequested);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteContact(@PathVariable String email){
        ResponseEntity<String> message = contactInfoService.deleteContactByEmail(email);
        return message;
    }


}
