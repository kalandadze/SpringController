package com.example.SpringControllers.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    private String id;
    private User user;
    private String content;

    public Post(User user,String content) {
        this.content = content;
        this.user = user;
    }
}
