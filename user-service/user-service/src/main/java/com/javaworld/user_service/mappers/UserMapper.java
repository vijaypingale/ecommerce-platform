package com.javaworld.user_service.mappers;

import com.javaworld.user_service.dto.CredentialDto;
import com.javaworld.user_service.dto.UserDto;
import com.javaworld.user_service.models.Credential;
import com.javaworld.user_service.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = CredentialMapper.class)
public interface UserMapper {

   @Mapping(source = "email",target = "emailAddress")
   @Mapping(source = "phone",target = "contactNumber")
   @Mapping(source = "credential", target = "credentialDto", qualifiedByName = "mapCredential")
   UserDto toDto(User user);

   @Mapping(source = "emailAddress",target = "email")
   @Mapping(source = "contactNumber",target = "phone")
   @Mapping(source = "credentialDto", target = "credential", qualifiedByName = "mapCredentialDto")
   User toEntity(UserDto userDto);

   @Named("mapCredential")
   default CredentialDto mapCredential(Credential credential) {
       if (credential == null) {
           return null;
       }
       CredentialDto credentialDto = new CredentialDto();
       credentialDto.setUsername(credential.getUsername());
       credentialDto.setPassword(credential.getPassword());
       credentialDto.setRoleBasedAuthority(credential.getRoleBasedAuthority());
       return credentialDto;
   }

   @Named("mapCredentialDto")
   default Credential mapCredentialDto(CredentialDto credentialDto) {
       if (credentialDto == null) {
           return null;
       }
       Credential credential = new Credential();
       credential.setUsername(credentialDto.getUsername());
       credential.setPassword(credentialDto.getPassword());
       credential.setRoleBasedAuthority(credentialDto.getRoleBasedAuthority());
       return credential;
   }

}
