package com.example.task.controller;

import com.example.task.dto.UserDto;
import com.example.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{login}")
    public ResponseEntity<UserDto> getUser(@PathVariable("login") String login) {
        return new ResponseEntity<>(userService.getUser(login), HttpStatus.OK);
    }
}