package com.example.demo4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "course")
public class Course {
    @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;

        private String title;

        @ManyToMany(mappedBy = "courses")
        @JsonIgnore //ilişki çift taraflı olduğundan JSON dönerken sonsuz döngü oluşabilir. Bunu önlemek için bunu yazdık
        private Set<Student> students = new HashSet<>();
    }

