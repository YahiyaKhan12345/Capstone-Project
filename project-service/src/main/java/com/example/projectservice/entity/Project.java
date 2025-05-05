package com.example.projectservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @NotBlank(message = "Project type is required")
    private String type;

    @NotBlank(message = "Project status is required")
    private String status;

    private String region; // Made optional by removing @NotBlank

    @NotNull(message = "Estimated labor hours is required")
    private Integer estimatedLaborHours;

    private Double estimatedLaborCost;

    @NotNull(message = "User ID is required")
    private Long userId;
}
