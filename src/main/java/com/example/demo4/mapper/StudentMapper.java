package com.example.demo4.mapper;

import com.example.demo4.dto.CourseResponseDTO;
import com.example.demo4.dto.StudentRequestDTO;
import com.example.demo4.dto.StudentResponseDTO;
import com.example.demo4.entity.Student;

public class StudentMapper {
    public static Student toEntity(StudentRequestDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        return student;
    }

    public static StudentResponseDTO toResponseDto(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setName(student.getName());
        return dto;
    }
}