package com.training.mentoring.demo.impl;

import com.training.mentoring.demo.entities.ContactInfo;
import com.training.mentoring.demo.repositories.ContactInfoRepository;
import com.training.mentoring.demo.services.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    @Autowired
    ContactInfoRepository contactInfoRepository;
    @Override
    public ContactInfo getContactById(Long id) {
        return contactInfoRepository.getReferenceById(id);
    }

    @Override
    public List<ContactInfo> getAllContacts() {
        return contactInfoRepository.findAll();
    }

    @Override
    public void saveContactInfo(ContactInfo contactInfo) {
        contactInfoRepository.save(contactInfo);
    }


}
