package com.springjwt.services;


import com.springjwt.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    Optional<User> findById(int id);
    User save(User user);
    void deleteById(int id);
}
