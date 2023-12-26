package com.springjwt.services;

import com.springjwt.dto.CourseDTO;
import com.springjwt.dto.CourseTypeDTO;
import com.springjwt.entities.Course;
import com.springjwt.entities.CourseType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {
    List<CourseDTO> getAll();
    CourseDTO findById(int id);
    Course save(Course course);
    void deleteById(int id);

    List<CourseDTO> findCourseByCourseType(CourseType CourseType);
    List<CourseDTO> findCourseByIsFree(boolean isFree);

}
