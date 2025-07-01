package com.training.mentoring.demo.util;

import com.training.mentoring.demo.dto.ContactInfoDto;
import com.training.mentoring.demo.entities.ContactInfoEntity;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("util")
public class MappingObjectsUtilTest {

    @Test
    void mapDtoToEntity_shouldCopyAllFields() {
        ContactInfoDto dto = new ContactInfoDto();
        dto.setFirstName("John");
        dto.setLastName("Doe");
        dto.setEmail("john@doe.com");
        dto.setCountry("US");
        dto.setCity("NYC");
        dto.setStreet("Main St");
        dto.setPostalCode("12345");
        dto.setPhoneNumber("1111");

        ContactInfoEntity entity = MappingObjectsUtil.mapDtoToEntity.apply(dto);

        assertEquals(dto.getFirstName(), entity.getFirstName());
        assertEquals(dto.getLastName(), entity.getLastName());
        assertEquals(dto.getEmail(), entity.getEmail());
        assertEquals(dto.getCountry(), entity.getCountry());
        assertEquals(dto.getCity(), entity.getCity());
        assertEquals(dto.getStreet(), entity.getStreet());
        assertEquals(dto.getPostalCode(), entity.getPostalCode());
        assertEquals(dto.getPhoneNumber(), entity.getPhoneNumber());
    }

    @Test
    void mapEntityToDto_shouldCopyAllFields() {
        ContactInfoEntity entity = new ContactInfoEntity();
        entity.setFirstName("Jane");
        entity.setLastName("Doe");
        entity.setEmail("jane@doe.com");
        entity.setCountry("US");
        entity.setCity("LA");
        entity.setStreet("Second St");
        entity.setPostalCode("54321");
        entity.setPhoneNumber("2222");

        ContactInfoDto dto = MappingObjectsUtil.mapEntityToDto.apply(entity);

        assertEquals(entity.getFirstName(), dto.getFirstName());
        assertEquals(entity.getLastName(), dto.getLastName());
        assertEquals(entity.getEmail(), dto.getEmail());
        assertEquals(entity.getCountry(), dto.getCountry());
        assertEquals(entity.getCity(), dto.getCity());
        assertEquals(entity.getStreet(), dto.getStreet());
        assertEquals(entity.getPostalCode(), dto.getPostalCode());
        assertEquals(entity.getPhoneNumber(), dto.getPhoneNumber());
    }
}
