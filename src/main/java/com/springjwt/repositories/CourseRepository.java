package com.springjwt.repositories;

import com.springjwt.entities.Course;
import com.springjwt.entities.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findCourseByCourseType(CourseType CourseType);
    List<Course> findCourseByIsFree(boolean isFree);
}
