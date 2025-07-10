package com.example.SpringControllers.service.exeption;

public class EmailTakenException extends RuntimeException {
    public EmailTakenException(String email) {
        super("user with email - " + email + " already exists");
    }
}
