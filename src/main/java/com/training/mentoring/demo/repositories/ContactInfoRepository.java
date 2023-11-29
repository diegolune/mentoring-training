package com.training.mentoring.demo.repositories;

import com.training.mentoring.demo.entities.ContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInfoRepository  extends JpaRepository<ContactInfoEntity, Long> {
    void deleteByEmail(String email);
}
