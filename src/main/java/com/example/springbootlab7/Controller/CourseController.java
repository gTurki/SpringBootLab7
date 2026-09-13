package com.example.springbootlab7.Controller;

import com.example.springbootlab7.Api.ApiResponse;
import com.example.springbootlab7.Model.Course;
import com.example.springbootlab7.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getCourse() {
        return ResponseEntity.status(200).body(courseService.getCourses());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid Course course, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course is added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable String id, @RequestBody @Valid Course course, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = courseService.updateCourse(id, course);
        if (isUpdated)
            return ResponseEntity.status(200).body(new ApiResponse("Course is updated successfully"));

        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id) {
        boolean isDeleted = courseService.deleteCourse(id);

        if (isDeleted)
            return ResponseEntity.status(200).body(new ApiResponse("Course is deleted successfully"));

        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @GetMapping("/get/credits/{credits}")
    public ResponseEntity<?> getCoursesHasXCreditsOrMore(@PathVariable double credits) {
        ArrayList<Course> temp = courseService.getCoursesHasXCreditsOrMore(credits);

        if (!temp.isEmpty())
            return ResponseEntity.status(200).body(temp);

        return ResponseEntity.status(400).body(new ApiResponse("No courses have more than " + credits + " credits"));
    }

    @PutMapping("/update/instructor/{id}/{instructor}")
    public ResponseEntity<?> changeCourseInstructor(@PathVariable String id, @PathVariable String instructor) {
        boolean isChanged = courseService.changeCourseInstructor(id, instructor);
        if (isChanged)
            return ResponseEntity.status(200).body(new ApiResponse("Instructor changed successfully"));

        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }
}
