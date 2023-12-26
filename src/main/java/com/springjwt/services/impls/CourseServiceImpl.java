package com.springjwt.services.impls;

import com.springjwt.dto.CourseDTO;
import com.springjwt.dto.CourseTypeDTO;
import com.springjwt.entities.Course;
import com.springjwt.entities.CourseType;
import com.springjwt.repositories.CourseRepository;
import com.springjwt.services.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final ModelMapper modelMapper;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CourseDTO> getAll() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO findById(int id) {
        Optional<Course> course = courseRepository.findById(id);
        return modelMapper.map(course.get(), CourseDTO.class);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseDTO> findCourseByCourseType(CourseType CourseType) {
        List<Course> courses = courseRepository.findCourseByCourseType(CourseType);
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findCourseByIsFree(boolean isFree) {
        List<Course> courses = courseRepository.findCourseByIsFree(isFree);
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }
}
