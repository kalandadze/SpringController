package com.example.SpringControllers.controller;

import com.example.SpringControllers.dto.PostCollectionDto;
import com.example.SpringControllers.model.Post;
import com.example.SpringControllers.model.User;
import com.example.SpringControllers.service.PostRestControllerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostRestController {
    PostRestControllerService service;

    @Autowired
    public PostRestController(PostRestControllerService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> AddPost(@RequestParam("text") String postContent, HttpServletRequest request){
        try {
            service.addPost(postContent,request);
            return ResponseEntity.status(HttpStatus.CREATED).body("New post successfully added");
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> GetPosts(HttpServletRequest request){
        try {
            PostCollectionDto response=service.getPosts(request);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

}
