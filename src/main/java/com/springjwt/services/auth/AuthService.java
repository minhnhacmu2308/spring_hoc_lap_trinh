package com.springjwt.services.auth;

import com.springjwt.dto.SignupDTO;
import com.springjwt.dto.UserDTO;
import com.springjwt.entities.User;

public interface AuthService {
    UserDTO createUser(User user);

    public void register(User user);
}
