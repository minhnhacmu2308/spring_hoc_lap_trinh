package com.springjwt.controllers;

import com.springjwt.entities.User;
import com.springjwt.repositories.UserRepository;
import com.springjwt.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody User user) {
        User checkExisted = userRepository.findFirstByEmail(user.getEmail());
        if (checkExisted != null) {
            return new ResponseEntity<>("Email đã tồn tại ", HttpStatus.CONFLICT);
        }
        authService.register(user);

        return new ResponseEntity<>("Đăng ký tài khoản thành công",HttpStatus.CREATED);
    }

}
