package com.springjwt.services.impls;

import com.springjwt.dto.CourseDTO;
import com.springjwt.dto.CourseTypeDTO;
import com.springjwt.dto.NewsDTO;
import com.springjwt.entities.Course;
import com.springjwt.entities.CourseType;
import com.springjwt.entities.News;
import com.springjwt.repositories.NewsRepository;
import com.springjwt.services.NewsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<NewsDTO> getAll() {
        List<News> newss = newsRepository.findAll();
        return newss.stream()
                .map(news -> modelMapper.map(news, NewsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public NewsDTO findById(int id) {
        Optional<News> news = newsRepository.findById(id);
        return modelMapper.map(news.get(), NewsDTO.class);
    }

    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    public void deleteById(int id) {
        newsRepository.deleteById(id);
    }
}
