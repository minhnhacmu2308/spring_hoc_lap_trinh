package com.springjwt.services;


import com.springjwt.dto.CourseDTO;
import com.springjwt.dto.OrderDTO;
import com.springjwt.entities.CourseType;
import com.springjwt.entities.Order;
import com.springjwt.entities.User;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAll();
    Optional<Order> findById(int id);
    Order save(Order order);
    void deleteById(int id);

    List<OrderDTO> findOrderByUser(User user);
}
