package com.javaworld.user_service.dto;

import com.javaworld.user_service.models.RoleBasedAuthority;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CredentialDto {

    private String username;
    private String password;
    private RoleBasedAuthority roleBasedAuthority;

}
