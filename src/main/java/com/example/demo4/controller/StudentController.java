package com.example.demo4.controller;

import com.example.demo4.dto.StudentRequestDTO;
import com.example.demo4.dto.StudentResponseDTO;
import com.example.demo4.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping
    public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO dto) {
        return studentService.createStudent(dto);
    }

    // READ
    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    // UPDATE
    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable Long id, @RequestBody StudentRequestDTO dto) {
        return studentService.updateStudent(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    // RELATION (Many-to-Many)
    @PostMapping("/{studentId}/courses/{courseId}")
    public StudentResponseDTO addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.assignCourseToStudent(studentId, courseId);
    }

    @DeleteMapping("/{studentId}/courses/{courseId}")
    public StudentResponseDTO removeCourseFromStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.removeCourseFromStudent(studentId, courseId);
    }
}
