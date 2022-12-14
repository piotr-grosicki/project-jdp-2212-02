package com.kodilla.ecommercee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GroupGlobalException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(GroupNotFoundException.class)
    public ResponseEntity<Object> handleTaskNotFoundException(GroupNotFoundException exception){
        return new ResponseEntity<>("HTTPStatus is Bad_Request", HttpStatus.BAD_REQUEST);
    }
}
