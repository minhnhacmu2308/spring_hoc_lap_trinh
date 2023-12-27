package com.springjwt.controllers;

import com.springjwt.dto.UserDTO;
import com.springjwt.entities.User;
import com.springjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-auth/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

//    @GetMapping("/{id}")
//    public Optional<User> getUserById(@PathVariable int id) {
//        return userService.findById(id);
//    }

    @GetMapping("/{email}")
    public UserDTO getUserById(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        User existingUser = userService.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setFullName(updatedUser.getFullName());
            existingUser.setPassword(existingUser.getPassword());
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            existingUser.setAddress(updatedUser.getAddress());
            // Update other attributes as needed
            return userService.save(existingUser);
        } else {
            return null;
        }
    }

    @PutMapping("/change-password/{id}")
    public boolean updatePassword(@PathVariable int id, @RequestBody User updatedUser) {

        User existingUser = userService.findById(id).orElse(null);
        if (existingUser != null) {
            String passwordBCrypt = new BCryptPasswordEncoder().encode(updatedUser.getPassword());
            existingUser.setPassword(passwordBCrypt);
            userService.save(existingUser);
            // Update other attributes as needed
            return true;
        } else {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteById(id);
    }
}
