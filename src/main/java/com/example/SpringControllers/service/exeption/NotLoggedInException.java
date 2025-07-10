package com.example.SpringControllers.service.exeption;

public class NotLoggedInException extends RuntimeException {
    public NotLoggedInException() {
        super("Log in needed for this action");
    }
}
