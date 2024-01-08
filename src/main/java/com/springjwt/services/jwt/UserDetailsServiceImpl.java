package com.springjwt.services.jwt;

import com.springjwt.entities.User;
import com.springjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        //Write Logic to get the user from the DB
        User user = userRepository.findFirstByEmail(email);
        if(user != null && user.getStatus() == 1){
            authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
        }else{
            throw new UsernameNotFoundException("User not found",null);
        }
    }
}
