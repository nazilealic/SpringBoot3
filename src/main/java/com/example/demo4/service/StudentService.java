package com.example.demo4.service;

import com.example.demo4.dto.StudentRequestDTO;
import com.example.demo4.dto.StudentResponseDTO;
import com.example.demo4.entity.Course;
import com.example.demo4.entity.Student;
import com.example.demo4.mapper.StudentMapper;
import com.example.demo4.repository.CourseRepository;
import com.example.demo4.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentServiceImpl {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentService(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepo.findAll().stream()
                .map(StudentMapper::toResponseDto)
                .toList();
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO dto) {
        Student student = StudentMapper.toEntity(dto);
        Student saved = studentRepo.save(student);
        return StudentMapper.toResponseDto(saved);
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {
        return studentRepo.findById(id)
                .map(student -> {
                    student.setName(dto.getName());
                    Student updated = studentRepo.save(student);
                    return StudentMapper.toResponseDto(updated);
                })
                .orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public StudentResponseDTO assignCourseToStudent(Long studentId, Long courseId) {
        Optional<Student> studentOpt = studentRepo.findById(studentId);
        Optional<Course> courseOpt = courseRepo.findById(courseId);

        if (studentOpt.isPresent() && courseOpt.isPresent()) {
            Student student = studentOpt.get();
            Course course = courseOpt.get();
            student.addCourse(course);
            Student saved = studentRepo.save(student);
            return StudentMapper.toResponseDto(saved);
        }
        return null;
    }

    @Override
    public StudentResponseDTO removeCourseFromStudent(Long studentId, Long courseId) {
        Optional<Student> studentOpt = studentRepo.findById(studentId);
        Optional<Course> courseOpt = courseRepo.findById(courseId);

        if (studentOpt.isPresent() && courseOpt.isPresent()) {
            Student student = studentOpt.get();
            Course course = courseOpt.get();
            student.removeCourse(course);
            Student saved = studentRepo.save(student);
            return StudentMapper.toResponseDto(saved);
        }
        return null;
    }
}