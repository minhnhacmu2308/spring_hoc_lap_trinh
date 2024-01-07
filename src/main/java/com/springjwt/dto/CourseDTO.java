package com.springjwt.dto;

import com.springjwt.entities.CourseType;
import com.springjwt.entities.CourseVideo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CourseDTO {
    private int courseId;
    private String courseName;
    private String image;
    private String description;
    private int price;
    private boolean isFree;
    private Date createdAt;
    private CourseTypeDTO courseType;
    private List<CourseVideoDTO> courseVideos;
    private List<OrderLinkDTO> orders;
}
