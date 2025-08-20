package com.example.demo4.service;

import com.example.demo4.dto.StudentRequestDTO;
import com.example.demo4.dto.StudentResponseDTO;
import com.example.demo4.entity.Course;
import com.example.demo4.entity.Student;

import java.util.List;

public interface StudentServiceImpl {
    List<StudentResponseDTO> getAllStudents();
    StudentResponseDTO createStudent(StudentRequestDTO dto);
    StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto);
    void deleteStudent(Long id);
    StudentResponseDTO assignCourseToStudent(Long studentId, Long courseId);
    StudentResponseDTO removeCourseFromStudent(Long studentId, Long courseId);
}
