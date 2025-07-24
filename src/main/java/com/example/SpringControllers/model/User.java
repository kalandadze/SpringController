package com.example.SpringControllers.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {
    @Id
    private String id;
    private String username;
    private LocalDate birthDate;
    private String email;
    private String password;
}
