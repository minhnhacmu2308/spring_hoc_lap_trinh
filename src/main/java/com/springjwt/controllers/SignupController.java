package com.springjwt.controllers;

import com.springjwt.entities.User;
import com.springjwt.repositories.UserRepository;
import com.springjwt.services.EmailService;
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

    @Autowired
    private EmailService emailService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody User user) {
        User checkExisted = userRepository.findFirstByEmail(user.getEmail());
        if (checkExisted != null) {
            return new ResponseEntity<>("Email đã tồn tại ", HttpStatus.CONFLICT);
        }
        user.setStatus(0);
        authService.register(user);
        String to = user.getEmail();
        String url = "http://localhost:8080/api/active-account/"+to;
        String subject = "Xác nhận đăng ký";
        String text = "Link active account : <a href='" + url + "' target = '_blank'>Click here</a>";
        emailService.sendEmail(to, subject, text);
        return new ResponseEntity<>("Đăng ký tài khoản thành công",HttpStatus.CREATED);
    }

}
