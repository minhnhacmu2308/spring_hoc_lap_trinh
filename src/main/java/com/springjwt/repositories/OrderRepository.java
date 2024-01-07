package com.springjwt.repositories;

import com.springjwt.entities.Course;
import com.springjwt.entities.CourseType;
import com.springjwt.entities.Order;
import com.springjwt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findOrderByUser(User user);
}
