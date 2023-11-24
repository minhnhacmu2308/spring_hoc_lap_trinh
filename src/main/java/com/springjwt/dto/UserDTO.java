package com.springjwt.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDTO {

    private Long userId;

    private String fullName;

    private String email;

    private String password;

    private String phoneNumber;

    private String address;

    private String gender;

    private int status;



}
