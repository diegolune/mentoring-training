package com.training.mentoring.demo.services;

import com.training.mentoring.demo.entities.ContactInfoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactInfoService {

    ContactInfoEntity getContactById(Long id);
    List<ContactInfoEntity> getAllContacts();

    void saveContactInfo(ContactInfoEntity contactInfo);
}
