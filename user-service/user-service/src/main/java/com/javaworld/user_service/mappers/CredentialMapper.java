package com.javaworld.user_service.mappers;


import com.javaworld.user_service.dto.CredentialDto;
import com.javaworld.user_service.models.Credential;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CredentialMapper {
    CredentialDto toDto(Credential credential);
    Credential toEntity(CredentialDto credentialDto);
}

