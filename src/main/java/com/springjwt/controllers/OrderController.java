package com.springjwt.controllers;

import com.springjwt.entities.Order;
import com.springjwt.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable int id) {
        return orderService.findById(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable int id, @RequestBody Order updatedOrder) {
        Order existingOrder = orderService.findById(id).orElse(null);
        if (existingOrder != null) {
            existingOrder.setOrderDate(updatedOrder.getOrderDate());
            existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
            existingOrder.setUser(updatedOrder.getUser());
            existingOrder.setCourse(updatedOrder.getCourse());
            // Update other attributes as needed
            return orderService.save(existingOrder);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteById(id);
    }
}
