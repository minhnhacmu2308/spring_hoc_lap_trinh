package com.springjwt.services.impls;

import com.springjwt.dto.CourseDTO;
import com.springjwt.dto.CourseTypeDTO;
import com.springjwt.entities.Course;
import com.springjwt.entities.CourseType;
import com.springjwt.repositories.CourseTypeRepository;
import com.springjwt.services.CourseTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @Override
    public List<CourseTypeDTO> getAll() {
        List<CourseType> courseTypes = courseTypeRepository.findAll();
        return courseTypes.stream()
                .map(courseType -> modelMapper.map(courseType, CourseTypeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CourseType> findById(int id) {
        return courseTypeRepository.findById(id);
    }

    @Override
    public CourseType save(CourseType courseType) {
        return courseTypeRepository.save(courseType);
    }

    @Override
    public void deleteById(int id) {
        courseTypeRepository.deleteById(id);
    }
}
