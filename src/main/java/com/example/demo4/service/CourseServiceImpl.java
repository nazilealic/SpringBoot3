package com.example.demo4.service;

import com.example.demo4.dto.CourseRequestDTO;
import com.example.demo4.dto.CourseResponseDTO;
import com.example.demo4.entity.Course;

import java.util.List;

public interface CourseServiceImpl {
    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO createCourse(CourseRequestDTO dto);
    CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto);
    void deleteCourse(Long id);
}
