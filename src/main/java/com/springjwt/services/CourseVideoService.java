package com.springjwt.services;


import com.springjwt.entities.CourseVideo;

import java.util.List;
import java.util.Optional;

public interface CourseVideoService {
    List<CourseVideo> getAll();
    Optional<CourseVideo> findById(int id);
    CourseVideo save(CourseVideo courseVideo);
    void deleteById(int id);
}
