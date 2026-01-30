package com.javaworld.user_service.service;

import com.javaworld.user_service.dto.UserDto;
import com.javaworld.user_service.mappers.UserMapper;
import com.javaworld.user_service.models.Credential;
import com.javaworld.user_service.models.User;
import com.javaworld.user_service.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository  userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        Credential credential = user.getCredential();
        
        // Check if credential exists, if not create one from CredentialDto
        if (credential == null && userDto.getCredentialDto() != null) {
            credential = new Credential();
            credential.setUsername(userDto.getCredentialDto().getUsername());
            credential.setPassword(userDto.getCredentialDto().getPassword());
            credential.setRoleBasedAuthority(userDto.getCredentialDto().getRoleBasedAuthority());
            user.setCredential(credential);
        }
        
        //TODO : we are providing original password in db but we need to store in encoded password

        // BiDirectional - set the relationship both ways
        if (credential != null) {
            credential.setUser(user);
        }
        
        User dbUser = userRepository.save(user);

        return userMapper.toDto(dbUser);
    }

    @Override
    public UserDto findById(Integer userId) {
        return userRepository.findById(userId).map(userMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
    }

    @Override
    public UserDto update(Integer id, UserDto userDto) {
        return null;
    }



}
