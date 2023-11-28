package com.training.mentoring.demo.services;

import com.training.mentoring.demo.entities.ContactInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactInfoService {

    ContactInfo getContactById(Long id);
    List<ContactInfo> getAllContacts();

    void saveContactInfo(ContactInfo contactInfo);
}
