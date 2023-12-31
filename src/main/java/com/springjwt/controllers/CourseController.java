package com.springjwt.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.springjwt.dto.CourseDTO;
import com.springjwt.dto.CourseTypeDTO;
import com.springjwt.entities.Course;
import com.springjwt.entities.CourseType;
import com.springjwt.repositories.CourseRepository;
import com.springjwt.services.CourseService;
import com.springjwt.services.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseTypeService courseTypeService;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @GetMapping("/type/{isFree}")
    public List<CourseDTO> getCourseByIsFree(@PathVariable int isFree) {
        boolean param = false;
        if(isFree == 1){
            param = true;
        }
        return courseService.findCourseByIsFree(param);
    }

    @GetMapping("/category/{id}")
    public List<CourseDTO> getCourseByType(@PathVariable int id) {
        Optional<CourseType> courseType = courseTypeService.findById(id);
        return courseService.findCourseByCourseType(courseType.get());
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Upload ảnh lên Cloudinary
            Map<?, ?> result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());

            // Trả về URL của ảnh đã upload
            String imageUrl = (String) result.get("url");
            return ResponseEntity.ok().body(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error uploading image");
        }
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course updatedCourse) {
        Optional<Course> existingCourseOptional = courseRepository.findById(id);

        if (existingCourseOptional.isPresent()) {
            Course existingCourse = existingCourseOptional.get();
            existingCourse.setCourseName(updatedCourse.getCourseName());
            existingCourse.setImage(updatedCourse.getImage());
            existingCourse.setDescription(updatedCourse.getDescription());
            existingCourse.setPrice(updatedCourse.getPrice());
            existingCourse.setFree(updatedCourse.isFree());
            existingCourse.setCourseType(updatedCourse.getCourseType());
            // Update other attributes as needed

            return courseService.save(existingCourse);
        } else {
            return null; // Handle not found error
        }
    }


    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteById(id);
    }
}
