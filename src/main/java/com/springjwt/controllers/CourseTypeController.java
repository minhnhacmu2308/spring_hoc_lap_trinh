package com.springjwt.controllers;

import com.springjwt.entities.CourseType;
import com.springjwt.services.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courseTypes")
public class CourseTypeController {

    @Autowired
    private CourseTypeService courseTypeService;

    @GetMapping
    public List<CourseType> getAllCourseTypes() {
        return courseTypeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CourseType> getCourseTypeById(@PathVariable int id) {
        return courseTypeService.findById(id);
    }

    @PostMapping
    public CourseType createCourseType(@RequestBody CourseType courseType) {
        return courseTypeService.save(courseType);
    }

    @PutMapping("/{id}")
    public CourseType updateCourseType(@PathVariable int id, @RequestBody CourseType updatedCourseType) {
        CourseType existingCourseType = courseTypeService.findById(id).orElse(null);
        if (existingCourseType != null) {
            existingCourseType.setTypeName(updatedCourseType.getTypeName());
            // Update other attributes as needed
            return courseTypeService.save(existingCourseType);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCourseType(@PathVariable int id) {
        courseTypeService.deleteById(id);
    }
}
