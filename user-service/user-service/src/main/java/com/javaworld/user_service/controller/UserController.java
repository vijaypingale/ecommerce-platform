package com.javaworld.user_service.controller;

import com.javaworld.user_service.dto.UserDto;
import com.javaworld.user_service.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDto createUser(@Valid @RequestBody UserDto userDto){
        log.info("In UserContoller :: createUser {} ", userDto.getEmailAddress());
        return userService.save(userDto);
    }

    @GetMapping("/{userId}")
    public UserDto fetchUser(@PathVariable Integer userId){
        log.info("UserContoller :: fetchUser {} ", userId);
        return userService.findById(userId);

    }

}
