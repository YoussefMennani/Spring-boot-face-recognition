package com.face_recognition.exception.presence;

public class PresenceNotFoundException extends RuntimeException{

    public PresenceNotFoundException(String message) {
        super(message);
    }

    public PresenceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
