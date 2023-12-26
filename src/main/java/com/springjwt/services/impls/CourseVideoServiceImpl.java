package com.springjwt.services.impls;

import com.springjwt.dto.CourseDTO;
import com.springjwt.dto.CourseVideoDTO;
import com.springjwt.entities.Course;
import com.springjwt.entities.CourseVideo;
import com.springjwt.repositories.CourseVideoRepository;
import com.springjwt.services.CourseVideoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseVideoServiceImpl implements CourseVideoService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CourseVideoRepository courseVideoRepository;

    @Override
    public List<CourseVideo> getAll() {
        return courseVideoRepository.findAll();
    }

    @Override
    public CourseVideoDTO findById(int id) {
        Optional<CourseVideo> course = courseVideoRepository.findById(id);
        return modelMapper.map(course.get(), CourseVideoDTO.class);
    }

    @Override
    public CourseVideo save(CourseVideo courseVideo) {
        return courseVideoRepository.save(courseVideo);
    }

    @Override
    public void deleteById(int id) {
        courseVideoRepository.deleteById(id);
    }
}
