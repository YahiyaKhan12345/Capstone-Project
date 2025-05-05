package com.example.userservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String gender;

    @Column(unique = true)
    private String email;



    private String password;

    private String role; // HOMEOWNER / CONTRACTOR
}

