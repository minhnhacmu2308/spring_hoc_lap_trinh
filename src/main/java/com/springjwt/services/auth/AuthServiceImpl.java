package com.springjwt.services.auth;

import com.springjwt.dto.SignupDTO;
import com.springjwt.dto.UserDTO;
import com.springjwt.entities.Role;
import com.springjwt.entities.User;
import com.springjwt.repositories.RoleRepository;
import com.springjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDTO createUser(User user) {
      return  null;
    }

    @Override
    public void register(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Role role = roleRepository.getById(2);
        user.setRole(role);
        userRepository.save(user);
    }
}
