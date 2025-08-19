package com.example.demo4.controller;

import com.example.demo4.entity.Course;
import com.example.demo4.entity.Student;
import com.example.demo4.service.StudentCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    //dependency of injection DoI
    private final StudentCourseService service;

    public StudentController(StudentCourseService service) {
        this.service = service;
    }

    //CREATE
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return service.createCourse(course);
    }

    // READ
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }

    // UPDATE
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return service.updateCourse(id, course);
    }

    // DELETE
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
    }

    // RELATION (Many-to-Many)
    @PostMapping("/students/{studentId}/courses/{courseId}")
    public Student addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return service.assignCourseToStudent(studentId, courseId);
    }

    @DeleteMapping("/students/{studentId}/courses/{courseId}")
    public Student removeCourseFromStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return service.removeCourseFromStudent(studentId, courseId);
    }
}
