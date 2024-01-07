package com.springjwt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;
    private String image;
    @Column(columnDefinition = "TEXT")
    private String description;
    private int price;
    private boolean isFree;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "courseTypesId")
    private CourseType courseType;

    @OneToMany(mappedBy = "course")
    private List<CourseVideo> courseVideos;

    @OneToMany(mappedBy = "course")
    private List<Order> orders;
}
