package com.example.SpringControllers.service;

import com.example.SpringControllers.dto.PostCollectionDto;
import com.example.SpringControllers.model.Post;
import com.example.SpringControllers.model.User;
import com.example.SpringControllers.repository.PostRepository;
import com.example.SpringControllers.repository.UserRepository;
import com.example.SpringControllers.service.exeption.EmailNotFoundException;
import com.example.SpringControllers.service.exeption.NotLoggedInException;
import com.example.SpringControllers.util.ModelConverter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PostRestControllerService {
    PostRepository repository;
    UserRepository userRepository;
    ModelConverter converter;

    @Autowired
    public PostRestControllerService(ModelConverter converter, PostRepository repository, UserRepository userRepository) {
        this.converter = converter;
        this.repository = repository;
        this.userRepository = userRepository;
    }


    // public functions

    public void addPost(String postContent, HttpServletRequest request) {
        User user = getUser(request);
        repository.addPost(new Post(user, postContent));
    }

    public PostCollectionDto getPosts(HttpServletRequest request) {
        String email = getUserEmail(request);
        List<Post> posts = repository.getPosts().stream().filter(post -> post.getUser().getEmail().equals(email)).toList();
        return converter.convert(posts);
    }


    // private functions

    private User getUser(HttpServletRequest req) {
        String email = getUserEmail(req);
        return userRepository.getUsers().stream().filter(x -> x.getEmail().equals(email)).findFirst().orElseThrow(() -> new EmailNotFoundException(email));
    }


    private String getUserEmail(HttpServletRequest req) {
        Cookie[] cookies=req.getCookies();
        if (cookies==null) throw new NotLoggedInException();
        return Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("email")).map(Cookie::getValue).findFirst().orElseThrow(NotLoggedInException::new);
    }
}
