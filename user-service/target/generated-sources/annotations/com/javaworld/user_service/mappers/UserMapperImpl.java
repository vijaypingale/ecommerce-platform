package com.javaworld.user_service.mappers;

import com.javaworld.user_service.dto.UserDto;
import com.javaworld.user_service.models.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-29T17:04:01-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setEmailAddress( user.getEmail() );
        userDto.setContactNumber( user.getPhone() );
        userDto.setCredentialDto( mapCredential( user.getCredential() ) );
        userDto.setUserId( user.getUserId() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastname( user.getLastname() );

        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userDto.getEmailAddress() );
        user.setPhone( userDto.getContactNumber() );
        user.setCredential( mapCredentialDto( userDto.getCredentialDto() ) );
        user.setUserId( userDto.getUserId() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastname( userDto.getLastname() );

        return user;
    }
}
