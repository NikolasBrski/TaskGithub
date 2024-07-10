package com.example.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NumberCannotBeZeroException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Followers cannot be zero";

    public NumberCannotBeZeroException() {
        super(ERROR_MESSAGE);
    }
}