package com.training.mentoring.demo.impl;

import com.training.mentoring.demo.entities.ContactInfoEntity;
import com.training.mentoring.demo.repositories.ContactInfoRepository;
import com.training.mentoring.demo.services.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    @Autowired
    ContactInfoRepository contactInfoRepository;

    @Override
    public ContactInfoEntity getContactById(Long id) {
        return contactInfoRepository.getReferenceById(id);
    }

    @Override
    public List<ContactInfoEntity> getAllContacts() {
        return contactInfoRepository.findAll();
    }

    @Override
    public void saveContactInfo(ContactInfoEntity contactInfo) {
        contactInfoRepository.save(contactInfo);
    }

    @Override
    public ResponseEntity<String> deleteContactByEmail(String email) {
        return contactInfoRepository.findByEmail(email).map(contact -> {
            contactInfoRepository.deleteByEmail(email);
            return ResponseEntity.ok("Contact with Email: " + email + " was deleted successfully");
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact with Email: " + email + " not exist"));
    }


}
