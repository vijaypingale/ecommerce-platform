package com.javaworld.user_service.mappers;

import com.javaworld.user_service.dto.CredentialDto;
import com.javaworld.user_service.models.Credential;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-29T17:04:01-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class CredentialMapperImpl implements CredentialMapper {

    @Override
    public CredentialDto toDto(Credential credential) {
        if ( credential == null ) {
            return null;
        }

        CredentialDto credentialDto = new CredentialDto();

        credentialDto.setUsername( credential.getUsername() );
        credentialDto.setPassword( credential.getPassword() );
        credentialDto.setRoleBasedAuthority( credential.getRoleBasedAuthority() );

        return credentialDto;
    }

    @Override
    public Credential toEntity(CredentialDto credentialDto) {
        if ( credentialDto == null ) {
            return null;
        }

        Credential credential = new Credential();

        credential.setPassword( credentialDto.getPassword() );
        credential.setRoleBasedAuthority( credentialDto.getRoleBasedAuthority() );
        credential.setUsername( credentialDto.getUsername() );

        return credential;
    }
}
