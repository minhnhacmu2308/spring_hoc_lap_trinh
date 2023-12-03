package com.springjwt.repositories;

import com.springjwt.entities.CourseVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseVideoRepository extends JpaRepository<CourseVideo, Integer> {
}
