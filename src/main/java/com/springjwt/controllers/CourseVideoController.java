package com.springjwt.controllers;

import com.springjwt.dto.CourseVideoDTO;
import com.springjwt.entities.CourseVideo;
import com.springjwt.services.CourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courseVideos")
public class CourseVideoController {

    @Autowired
    private CourseVideoService courseVideoService;

    @GetMapping
    public List<CourseVideo> getAllCourseVideos() {
        return courseVideoService.getAll();
    }

    @GetMapping("/{id}")
    public CourseVideoDTO getCourseVideoById(@PathVariable int id) {
        return courseVideoService.findById(id);
    }

    @PostMapping
    public CourseVideo createCourseVideo(@RequestBody CourseVideo courseVideo) {
        return courseVideoService.save(courseVideo);
    }

//    @PutMapping("/{id}")
//    public CourseVideo updateCourseVideo(@PathVariable int id, @RequestBody CourseVideo updatedCourseVideo) {
//        CourseVideo existingCourseVideo = courseVideoService.findById(id).orElse(null);
//        if (existingCourseVideo != null) {
//            existingCourseVideo.setVideoName(updatedCourseVideo.getVideoName());
//            existingCourseVideo.setVideoUrl(updatedCourseVideo.getVideoUrl());
//            // Update other attributes as needed
//            return courseVideoService.save(existingCourseVideo);
//        } else {
//            return null;
//        }
//    }

    @DeleteMapping("/{id}")
    public void deleteCourseVideo(@PathVariable int id) {
        courseVideoService.deleteById(id);
    }
}
