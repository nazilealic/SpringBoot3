package com.example.demo4.service;

import com.example.demo4.dto.CourseRequestDTO;
import com.example.demo4.dto.CourseResponseDTO;
import com.example.demo4.entity.Course;
import com.example.demo4.mapper.CourseMapper;
import com.example.demo4.repository.CourseRepository;
import com.example.demo4.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements CourseServiceImpl {

    private final CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return courseRepo.findAll().stream()
                .map(CourseMapper::toResponseDto)
                .toList();
    }

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO dto) {
        Course course = CourseMapper.toEntity(dto);
        Course saved = courseRepo.save(course);
        return CourseMapper.toResponseDto(saved);
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto) {
        return courseRepo.findById(id)
                .map(course -> {
                    course.setTitle(dto.getTitle());
                    Course updated = courseRepo.save(course);
                    return CourseMapper.toResponseDto(updated);
                })
                .orElse(null);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}