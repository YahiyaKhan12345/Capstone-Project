package com.example.userservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String fullName;
    private String gender;
    private String email;
    private String role;
}
