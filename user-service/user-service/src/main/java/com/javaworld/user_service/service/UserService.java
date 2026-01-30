package com.javaworld.user_service.service;

import com.javaworld.user_service.dto.UserDto;

public interface UserService {
   UserDto save(UserDto userDto);
   UserDto findById(Integer userId);
   UserDto update(Integer id, UserDto userDto);
}
