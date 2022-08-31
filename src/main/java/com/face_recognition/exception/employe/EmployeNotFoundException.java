package com.face_recognition.exception.employe;

public class EmployeNotFoundException extends RuntimeException{

    public EmployeNotFoundException(String message) {
        super(message);
    }

    public EmployeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
