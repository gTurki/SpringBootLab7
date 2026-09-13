package com.example.springbootlab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {

    @NotEmpty(message = "ID cannot be empty")
    @Size(min = 2, max = 6, message = "ID must be between 2-6 characters")
    @Pattern(regexp = "^(c\\d+)+$", message = "ID must start with 'c' followed by digit")
    private String id;
    @NotEmpty(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 20, message = "Name must be between 3-20 characters")
    private String name;
    @Positive(message = "Credits must be positive")
    private double credits;
    @NotEmpty(message = "Instructor cannot be empty")
    @NotBlank(message = "Instructor cannot be blank")
    private String associatedInstructor;
    @NotEmpty(message = "Course level cannot be empty")
    @Pattern(regexp = "^(freshman|sophomore|junior|senior)$", message = "Course level must be one of the following (freshman/sophomore/junior/senior)")
    private String courseLevel;
    private boolean isAvailable;
}
