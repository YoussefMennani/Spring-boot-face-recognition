package com.face_recognition.exception.presence;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PresenceExceptionHandler {

    @ExceptionHandler(PresenceNotFoundException.class)
    public ResponseEntity<Object> handlePresenceNotFoundException(PresenceNotFoundException presenceNotFoundException){

        PresenceException presenceException = new PresenceException(
                presenceNotFoundException.getMessage(),
                presenceNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return  new ResponseEntity<>(presenceException,HttpStatus.NOT_FOUND);
    }
}
