package com.example.demo4.service;

import com.example.demo4.entity.Course;
import com.example.demo4.entity.Student;
import com.example.demo4.repository.CourseRepository;
import com.example.demo4.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseService {
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;
    private Student student;
    private Course course;

    public StudentCourseService(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    // CREATE
    public Student createStudent(Student student) {
        this.student = student;
        return studentRepo.save(student);
    }

    public Course createCourse(Course course) {
        this.course = course;
        return courseRepo.save(course);
    }

    // READ
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepo.findById(id);
    }

    // UPDATE
    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepo.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    return studentRepo.save(student);
                })
                .orElse(null);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        return courseRepo.findById(id)
                .map(course -> {
                    course.setTitle(updatedCourse.getTitle());
                    return courseRepo.save(course);
                })
                .orElse(null);
    }

    // DELETE
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }

    // RELATION (Many-to-Many)
    public Student assignCourseToStudent(Long studentId, Long courseId) {
        Optional<Student> studentOpt = studentRepo.findById(studentId);
        Optional<Course> courseOpt = courseRepo.findById(courseId);

        if (studentOpt.isPresent() && courseOpt.isPresent()) {
            Student student = studentOpt.get();
            Course course = courseOpt.get();

            student.addCourse(course);
            return studentRepo.save(student);
        }
        return null;
    }

    public Student removeCourseFromStudent(Long studentId, Long courseId) {
        Optional<Student> studentOpt = studentRepo.findById(studentId);
        Optional<Course> courseOpt = courseRepo.findById(courseId);

        if (studentOpt.isPresent() && courseOpt.isPresent()) {
            Student student = studentOpt.get();
            Course course = courseOpt.get();

            student.removeCourse(course);
            return studentRepo.save(student);
        }
        return null;
    }
}
