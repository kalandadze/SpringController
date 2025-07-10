package com.example.SpringControllers.util;

import com.example.SpringControllers.dto.PostDto;
import com.example.SpringControllers.dto.PostCollectionDto;
import com.example.SpringControllers.dto.UserDto;
import com.example.SpringControllers.model.Post;
import com.example.SpringControllers.model.User;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ModelConverter {
    public UserDto convert(User user){
        return UserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .localDate(user.getBirthDate()).build();
    }
    public PostDto convert(Post post){
        return PostDto.builder()
                .content(post.getContent())
                .user(convert(post.getUser())).build();
    }
    public PostCollectionDto convert(Collection<Post> posts){
        return PostCollectionDto.builder()
                .posts(posts.stream().map(this::convert).toList()).build();
    }
}
