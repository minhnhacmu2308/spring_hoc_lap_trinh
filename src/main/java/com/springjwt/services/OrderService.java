package com.springjwt.services;


import com.springjwt.entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAll();
    Optional<Order> findById(int id);
    Order save(Order order);
    void deleteById(int id);
}
