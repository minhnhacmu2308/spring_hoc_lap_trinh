package com.springjwt.controllers;

import com.springjwt.dto.EmailResponseDTO;
import com.springjwt.dto.ForgotPasswordDTO;
import com.springjwt.dto.UserDTO;
import com.springjwt.entities.User;
import com.springjwt.services.EmailService;
import com.springjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class EmailController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/active-account/{email}")
    public ResponseEntity<?> activeAccount(@PathVariable String email) {
        UserDTO user = userService.findByEmail(email);
        if (user != null) {
            User existingUser = userService.findById(Integer.parseInt(String.valueOf(user.getUserId()))).orElse(null);
            if (existingUser != null) {
                existingUser.setStatus(1);
                userService.save(existingUser);
                return new ResponseEntity<>("Xác thực tài khoản thành công", HttpStatus.OK);
            }
        }
        return null;
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordDTO body) {
            UserDTO user = userService.findByEmail(body.getEmail());
        if (user != null) {
            User existingUser = userService.findById(Integer.parseInt(String.valueOf(user.getUserId()))).orElse(null);
            if (existingUser != null) {
                String otp = generateOTP();
                existingUser.setOtp(otp);
                userService.save(existingUser);
                String to = user.getEmail();
                String url = "http://localhost:8080/api/reset-password/"+otp +"/"+to;
                String subject = "Forgot password";
                String text = "Nhấn vào link để reset mat khau  " + url;
                emailService.sendEmail(to, subject, text);
                return new ResponseEntity<>("Request reset password success", HttpStatus.OK);
            }
        }
        return null;
    }

    @GetMapping("/reset-password/{otp}/{email}")
    public ResponseEntity<?> resetPassword(@PathVariable String otp , @PathVariable String email) {
        UserDTO user = userService.findByEmail(email);
        if (user != null) {
            User existingUser = userService.findById(Integer.parseInt(String.valueOf(user.getUserId()))).orElse(null);
            if (existingUser != null && existingUser.getOtp().equals(otp)) {
                String passwordBCrypt = new BCryptPasswordEncoder().encode("123456789");
                existingUser.setPassword(passwordBCrypt);
                existingUser.setOtp(null);
                userService.save(existingUser);
                String to = user.getEmail();
                String subject = "Mật khẩu mới ";
                String text = "Mật khẩu mới của bạn là :"+"<b>123456789</b>";
                emailService.sendEmail(to, subject, text);
                return new ResponseEntity<>("Reset mâjt khẩu thành công vui lòng check mail để nhận mật khẩu mới", HttpStatus.OK);
            }
        }
        return null;
    }

    private String generateOTP() {
        // Độ dài của mã OTP
        int otpLength = 6;

        // Ký tự cho mã OTP
        String otpChars = "0123456789";

        // Sinh mã OTP ngẫu nhiên
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < otpLength; i++) {
            int index = random.nextInt(otpChars.length());
            otp.append(otpChars.charAt(index));
        }

        return otp.toString();
    }
}
