package com.example.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ObjectNullException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Object cannot be null";

    public ObjectNullException() {
        super(ERROR_MESSAGE);
    }
}
