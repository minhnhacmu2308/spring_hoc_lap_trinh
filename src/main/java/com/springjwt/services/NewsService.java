package com.springjwt.services;

import com.springjwt.entities.News;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface NewsService {
    List<News> getAll();
    Optional<News> findById(int id);
    News save(News news);
    void deleteById(int id);
}
