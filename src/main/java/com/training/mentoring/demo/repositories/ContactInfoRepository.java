package com.training.mentoring.demo.repositories;

import com.training.mentoring.demo.entities.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInfoRepository  extends JpaRepository<ContactInfo, Long> {
}
