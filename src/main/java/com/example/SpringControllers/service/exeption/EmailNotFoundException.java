package com.example.SpringControllers.service.exeption;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(String email) {
        super("User with email - "+email+" not found");
    }
}
