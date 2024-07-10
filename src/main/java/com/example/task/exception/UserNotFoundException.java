package com.example.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private static final String ERROR_MESSAGE = "User with login: %s not founded";

    public UserNotFoundException(String login) {
        super(String.format(ERROR_MESSAGE, login));
    }
}
