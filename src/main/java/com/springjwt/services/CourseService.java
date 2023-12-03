package com.springjwt.services;

import com.springjwt.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {
    List<Course> getAll();
    Optional<Course> findById(int id);
    Course save(Course course);
    void deleteById(int id);
}
