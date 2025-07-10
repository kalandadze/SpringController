package com.example.SpringControllers.controller;

import com.example.SpringControllers.model.User;
import com.example.SpringControllers.service.UserRestControllerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController {
    UserRestControllerService service;

    @Autowired
    public UserRestController(UserRestControllerService service) {
        this.service = service;
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        try {
            service.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("New user successfully added");
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/login")
    public ResponseEntity<?> Login(@RequestParam String email, @RequestParam String password, HttpServletResponse response){
        try {
             service.login(email,password,response);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully logged in");
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<?> Login(HttpServletResponse response){
        try {
             service.logout(response);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully logged out");
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

}
