package com.springjwt.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {
    private int orderId;
    private Date orderDate;
    private int totalPrice;
    private UserDTO user;
    private CourseDTO course;
}
