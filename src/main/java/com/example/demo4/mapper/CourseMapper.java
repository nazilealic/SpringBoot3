package com.example.demo4.mapper;

import com.example.demo4.dto.CourseRequestDTO;
import com.example.demo4.dto.CourseResponseDTO;
import com.example.demo4.entity.Course;

public class CourseMapper {
    public static Course toEntity(CourseRequestDTO dto) {
        Course course = new Course();
        course.setTitle(dto.getTitle());
        return course;
    }

    public static CourseResponseDTO toResponseDto(Course course) {
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setTitle(course.getTitle());
        return dto;
    }
}