package com.springjwt.services.impls;

import com.springjwt.dto.CourseDTO;
import com.springjwt.dto.OrderDTO;
import com.springjwt.entities.Course;
import com.springjwt.entities.Order;
import com.springjwt.entities.User;
import com.springjwt.repositories.OrderRepository;
import com.springjwt.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDTO> findOrderByUser(User user) {
        List<Order> courses = orderRepository.findOrderByUser(user);
        return courses.stream()
                .map(course -> modelMapper.map(course, OrderDTO.class))
                .collect(Collectors.toList());
    }
}
