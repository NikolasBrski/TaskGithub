package com.example.task.controller;

import com.example.task.dto.ExceptionDto;
import com.example.task.exception.NumberCannotBeZeroException;
import com.example.task.exception.ObjectNullException;
import com.example.task.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NumberCannotBeZeroException.class, ObjectNullException.class})
    public ResponseEntity<Object> badRequestExceptionHandler(RuntimeException ex) {
        return new ResponseEntity<>(new ExceptionDto(ex.getMessage()), BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> notFoundExceptionHandler(RuntimeException ex) {
        return new ResponseEntity<>(new ExceptionDto(ex.getMessage()), NOT_FOUND);
    }
}
