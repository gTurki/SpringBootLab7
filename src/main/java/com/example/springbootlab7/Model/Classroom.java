package com.example.springbootlab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Classroom {

    @NotEmpty(message = "ID cannot be empty")
    @Size(min = 2, max = 6, message = "ID must be between 2-6 characters")
    @Pattern(regexp = "^(cr\\d+)+$", message = "ID must start with 'cr' followed by digit")
    private String id;
    @NotNull(message = "Room number cannot be null")
    @Positive(message = "Room number must be positive")
    private int roomNumber;
    @NotNull(message = "floor number cannot be null")
    @Positive(message = "floor number must be positive")
    private int floorNumber;
    @NotNull(message = "Capacity cannot be null")
    @Positive(message = "Capacity must be positive")
    private int capacity;
    private boolean hasWifi;
    @NotEmpty(message = "Room type cannot be empty")
    @Pattern(regexp = "^(lecture hall|computer lab|science lab)$", message = "Classroom must be one of the following (lecture hall/computer lab/science lab)")
    private String roomType;
}
