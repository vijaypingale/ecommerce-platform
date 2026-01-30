package com.javaworld.user_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Integer userId;
    private String firstName;
    
    @JsonProperty("lastName")
    private String lastname;
    
    private String emailAddress;
    
    @JsonProperty("contact")
    private String contactNumber;

    @JsonProperty("credential")
    private CredentialDto credentialDto;
}
