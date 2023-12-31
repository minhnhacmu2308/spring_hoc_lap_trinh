package com.springjwt.services;


import com.springjwt.dto.CourseTypeDTO;
import com.springjwt.entities.CourseType;

import java.util.List;
import java.util.Optional;

public interface CourseTypeService {
    List<CourseTypeDTO> getAll();
    Optional<CourseType> findById(int id);
    CourseType save(CourseType courseType);
    void deleteById(int id);
}
