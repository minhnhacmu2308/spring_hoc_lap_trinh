package com.springjwt.dto;

import lombok.Data;

@Data
public class CreatePaymentDTO {
    private int totalPrice;
    private int userId;
    private int courseId;
    private String email;
    private String paymentId;
    private String payerId;
}
