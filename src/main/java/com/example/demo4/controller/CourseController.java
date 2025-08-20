package com.example.demo4.controller;

import com.example.demo4.dto.CourseRequestDTO;
import com.example.demo4.dto.CourseResponseDTO;
import com.example.demo4.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // CREATE
    @PostMapping
    public CourseResponseDTO createCourse(@RequestBody CourseRequestDTO dto) {
        return courseService.createCourse(dto);
    }

    // READ
    @GetMapping
    public List<CourseResponseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    // UPDATE
    @PutMapping("/{id}")
    public CourseResponseDTO updateCourse(@PathVariable Long id, @RequestBody CourseRequestDTO dto) {
        return courseService.updateCourse(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
