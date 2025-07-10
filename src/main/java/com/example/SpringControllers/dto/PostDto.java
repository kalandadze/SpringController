package com.example.SpringControllers.dto;

import com.example.SpringControllers.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {
    private UserDto user;
    private String content;
}
