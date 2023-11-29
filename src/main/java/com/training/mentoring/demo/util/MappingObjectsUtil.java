package com.training.mentoring.demo.util;

import com.training.mentoring.demo.dto.ContactInfoDto;
import com.training.mentoring.demo.entities.ContactInfoEntity;

import java.util.function.Function;

public class MappingObjectsUtil {

    /**
     * Mapping Data Transfer Object to Entity
     * <p>
     * Convert Dto to Entity
     *
     * @param param1 {@link ContactInfoDto}
     * @param param2 {@link ContactInfoEntity}
     * @return returns a ContactInfoEntity
     * @throws ExceptionType // TODO: 28/11/23
     */
    public static final Function<ContactInfoDto, ContactInfoEntity> mapDtoToEntity = dto -> {
        ContactInfoEntity aContactInfoEntity = new ContactInfoEntity();
        aContactInfoEntity.setFirstName(dto.getFirstName());
        aContactInfoEntity.setLastName(dto.getLastName());
        aContactInfoEntity.setEmail(dto.getEmail());
        aContactInfoEntity.setBirthday(dto.getBirthday());
        aContactInfoEntity.setCountry(dto.getCountry());
        aContactInfoEntity.setCity(dto.getCity());
        aContactInfoEntity.setStreet(dto.getStreet());
        aContactInfoEntity.setPostalCode(dto.getPostalCode());
        aContactInfoEntity.setPhoneNumber(dto.getPhoneNumber());
        return aContactInfoEntity;
    };

  /**
   * Mapping Entity to Data Transfer Object
   * <p>
   * Convert Entity to Dto
   *
   * @param param1 {@link ContactInfoEntity}
   * @param param2 {@link ContactInfoDto}
   * @return returns a ContactInfoDto
   * @throws ExceptionType // TODO: 28/11/23
   */
  public static final Function<ContactInfoEntity, ContactInfoDto> mapEntityToDto = entity -> {
        ContactInfoDto aContactInfoDto = new ContactInfoDto();
        aContactInfoDto.setFirstName(entity.getFirstName());
        aContactInfoDto.setLastName(entity.getLastName());
        aContactInfoDto.setEmail(entity.getEmail());
        aContactInfoDto.setBirthday(entity.getBirthday());
        aContactInfoDto.setCountry(entity.getCountry());
        aContactInfoDto.setCity(entity.getCity());
        aContactInfoDto.setStreet(entity.getStreet());
        aContactInfoDto.setPostalCode(entity.getPostalCode());
        aContactInfoDto.setPhoneNumber(entity.getPhoneNumber());
        return aContactInfoDto;
    };
}
