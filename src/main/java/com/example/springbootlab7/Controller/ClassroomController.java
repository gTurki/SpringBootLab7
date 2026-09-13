package com.example.springbootlab7.Controller;

import com.example.springbootlab7.Api.ApiResponse;
import com.example.springbootlab7.Model.Classroom;
import com.example.springbootlab7.Service.ClassroomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/classroom")
@RequiredArgsConstructor
public class ClassroomController {
    private final ClassroomService classroomService;

    @GetMapping("/get")
    public ResponseEntity<?> getClassrooms() {
        return ResponseEntity.status(200).body(classroomService.getClassrooms());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addClassroom(@RequestBody @Valid Classroom classroom, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        classroomService.addClassroom(classroom);
        return ResponseEntity.status(200).body(new ApiResponse("Classroom is added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClassroom(@PathVariable String id, @RequestBody @Valid Classroom classroom, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = classroomService.updateClassroom(id, classroom);
        if (isUpdated)
            return ResponseEntity.status(200).body(new ApiResponse("Classroom is updated successfully"));

        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClassroom(@PathVariable String id) {
        boolean isDeleted = classroomService.deleteClassroom(id);

        if (isDeleted)
            return ResponseEntity.status(200).body(new ApiResponse("Classroom is deleted successfully"));

        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @GetMapping("/get/floor/{floorNumber}")
    public ResponseEntity<?> getAllRoomsInFloor(@PathVariable int floorNumber) {
        ArrayList<Classroom> temp = classroomService.getAllRoomsInFloor(floorNumber);

        if (!temp.isEmpty())
            return ResponseEntity.status(200).body(temp);

        return ResponseEntity.status(400).body(new ApiResponse("No classrooms in floor " + floorNumber));
    }

    @PutMapping("/update/capacity/{id}/{capacity}")
    public ResponseEntity<?> changeRoomCapacity(@PathVariable String id, @PathVariable int capacity) {
        boolean isUpdated = classroomService.changeRoomCapacity(id, capacity);
        if (isUpdated)
            return ResponseEntity.status(200).body(new ApiResponse("Classroom capacity updated successfully"));

        return ResponseEntity.status(400).body(new ApiResponse("ID not found or Capacity below 1"));
    }
}
