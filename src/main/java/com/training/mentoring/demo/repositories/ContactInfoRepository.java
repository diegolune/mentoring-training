package com.training.mentoring.demo.repositories;

import com.training.mentoring.demo.entities.ContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactInfoRepository  extends JpaRepository<ContactInfoEntity, Long> {
    void deleteByEmail(String email);
    Optional<ContactInfoEntity> findByEmail(String email);
}
