package com.example.demo4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_course", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();//çoklu ilişkilerde kullanılır. Aynı değerin tekrar set edilmesini engeller

    public void addCourse(Course course){
        courses.add(course);
        course.getStudents().add(this);
    }

    public void removeCourse(Course course){
        courses.remove(course);
        course.getStudents().remove(this);
    }
}

