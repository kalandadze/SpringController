package com.example.SpringControllers.service;

import com.example.SpringControllers.model.User;
import com.example.SpringControllers.repository.UserRepository;
import com.example.SpringControllers.service.exeption.EmailTakenException;
import com.example.SpringControllers.service.exeption.WrongPasswordOrEmailException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRestControllerService {
    UserRepository repository;
    private final int DAY=60*60*24;

    @Autowired
    public UserRestControllerService(UserRepository repository) {
        this.repository = repository;
    }

    // public functions

    public void register(User user) {
        checkValidity(user);
        repository.addUsers(user);
    }

    public void login(String email, String password, HttpServletResponse response) {
        login(email, password);
        Cookie cookie=setupCookie(email,DAY);
        response.addCookie(cookie);
    }

    public void logout(HttpServletResponse response) {
        Cookie cookie = setupCookie("",0);
        response.addCookie(cookie);
    }


    //private functions

    private void checkValidity(User newUser) {
        User duplicateUser = repository.getUsers().stream().filter(user -> user.getEmail().equals(newUser.getEmail())).findFirst().orElse(null);
        if (duplicateUser != null) throw new EmailTakenException(duplicateUser.getEmail());
    }

    private void login(String email, String password) {
        repository.getUsers().stream().filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password)).findFirst().orElseThrow(WrongPasswordOrEmailException::new);
    }

    private Cookie setupCookie(String email, int maxAge) {
        Cookie cookie = new Cookie("email",email);
        cookie.setMaxAge(maxAge);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        return cookie;
    }
}
