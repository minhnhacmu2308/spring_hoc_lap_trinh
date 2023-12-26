package com.springjwt.dto;

import lombok.Data;

@Data
public class NewsDTO {
    private int newsId;
    private String title;
    private String image;
    private String content;
}
