package com.example.SpringControllers.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDto {
    private String username;
    private LocalDate localDate;
    private String email;
}
