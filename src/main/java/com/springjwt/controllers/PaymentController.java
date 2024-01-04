package com.springjwt.controllers;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.springjwt.dto.CreatePaymentDTO;
import com.springjwt.dto.ForgotPasswordDTO;
import com.springjwt.dto.ResponseApi;
import com.springjwt.dto.UserDTO;
import com.springjwt.entities.Course;
import com.springjwt.entities.Order;
import com.springjwt.entities.User;
import com.springjwt.repositories.CourseRepository;
import com.springjwt.services.CourseService;
import com.springjwt.services.PayPalService;
import com.springjwt.services.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api/payment-online")
public class PaymentController {

    private static final double EXCHANGE_RATE = 0.000043;

    @Autowired
    private PayPalService payPalService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/create-payment")
    public ResponseEntity<ResponseApi> createPayment(@RequestBody CreatePaymentDTO body) throws PayPalRESTException {
        UserDTO user = userService.findByEmail(body.getEmail());
        if (user != null) {
            User existingUser = userService.findById(Integer.parseInt(String.valueOf(user.getUserId()))).orElse(null);
            if (existingUser != null) {
                String successUrl = "http://localhost:3001/payment/success";
                String cancelUrl = "http://localhost:3001/payment/cancel";
                double amountInUsd = convertVndToUsd(body.getTotalPrice());

                Payment createdPayment = payPalService.createPayment(String.valueOf(amountInUsd * 100),"USD",successUrl,cancelUrl);
                String url =  createdPayment.getLinks().stream()
                        .filter(link -> link.getRel().equals("approval_url"))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("No approval_url found in response"))
                        .getHref();
                ResponseApi responseApi = new ResponseApi();
                responseApi.setUrl(url);
                responseApi.setPaymentId(createdPayment.getId());
                return new ResponseEntity<>(responseApi, HttpStatus.OK);
            }
        }
        return null;
    }

    @GetMapping("/success")
    public ResponseEntity<?> createPaymentSuccess(@RequestBody CreatePaymentDTO body) throws PayPalRESTException {
        try {
            Payment payment = payPalService.executePayment(body.getPaymentId(), body.getPayerId());
            UserDTO user = userService.findByEmail(body.getEmail());
            User existingUser = userService.findById(Integer.parseInt(String.valueOf(user.getUserId()))).orElse(null);
            LocalDateTime localDateTime = LocalDateTime.now();
            // Chuyển đổi từ LocalDateTime sang Date
            Date date = convertToDate(localDateTime);
            Course course = courseRepository.findById(body.getCourseId()).get();
            double amountInUsd = convertVndToUsd(body.getTotalPrice());
            Order order = new Order();
            order.setUser(existingUser);
            order.setOrderDate(date);
            order.setCourse(course);
            order.setTotalPrice(amountInUsd);
            return new ResponseEntity<>("Payment executed successfully", HttpStatus.OK);
        } catch (PayPalRESTException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cancel")
    public ResponseEntity<?> cancelPayment() {
        return new ResponseEntity<>("Cancel payment", HttpStatus.OK);
    }

    private Date convertToDate(LocalDateTime localDateTime) {
        return java.sql.Timestamp.valueOf(localDateTime);
    }
    private double convertVndToUsd(double amountInVnd) {
        return amountInVnd * EXCHANGE_RATE;
    }
}
