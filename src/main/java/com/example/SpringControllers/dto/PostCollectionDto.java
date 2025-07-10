package com.example.SpringControllers.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostCollectionDto {
    private List<PostDto> posts;
}
