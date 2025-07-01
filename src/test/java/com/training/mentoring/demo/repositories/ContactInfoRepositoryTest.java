package com.training.mentoring.demo.repositories;

import com.training.mentoring.demo.entities.ContactInfoEntity;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Tag("repository")
public class ContactInfoRepositoryTest {

    @Autowired
    private ContactInfoRepository repository;

    @Test
    void findByEmail_shouldReturnSavedEntity() {
        ContactInfoEntity entity = new ContactInfoEntity();
        entity.setEmail("repo@test.com");
        repository.save(entity);

        Optional<ContactInfoEntity> result = repository.findByEmail("repo@test.com");
        assertTrue(result.isPresent());
        assertEquals("repo@test.com", result.get().getEmail());
    }

    @Test
    void deleteByEmail_shouldRemoveEntity() {
        ContactInfoEntity entity = new ContactInfoEntity();
        entity.setEmail("delete@test.com");
        repository.save(entity);

        repository.deleteByEmail("delete@test.com");
        assertTrue(repository.findByEmail("delete@test.com").isEmpty());
    }
}
