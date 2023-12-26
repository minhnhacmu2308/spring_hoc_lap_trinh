package com.springjwt.controllers;

import com.springjwt.dto.NewsDTO;
import com.springjwt.entities.News;
import com.springjwt.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<NewsDTO> getAllNews() {
        return newsService.getAll();
    }

    @GetMapping("/{id}")
    public NewsDTO getNewsById(@PathVariable int id) {
        return newsService.findById(id);
    }

    @PostMapping
    public News createNews(@RequestBody News news) {
        return newsService.save(news);
    }

//    @PutMapping("/{id}")
//    public News updateNews(@PathVariable int id, @RequestBody News updatedNews) {
//        News existingNews = newsService.findById(id).orElse(null);
//        if (existingNews != null) {
//            existingNews.setTitle(updatedNews.getTitle());
//            existingNews.setImage(updatedNews.getImage());
//            existingNews.setContent(updatedNews.getContent());
//            return newsService.save(existingNews);
//        } else {
//            return null; // Handle not found error
//        }
//    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable int id) {
        newsService.deleteById(id);
    }
}
