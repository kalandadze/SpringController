package com.example.SpringControllers.service.exeption;

public class WrongPasswordOrEmailException extends RuntimeException {
    public WrongPasswordOrEmailException() {
        super("Email or password is incorrect");
    }
}
