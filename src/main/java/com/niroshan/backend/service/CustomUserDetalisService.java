package com.niroshan.backend.service;

import com.niroshan.backend.model.User;
import com.niroshan.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetalisService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repository.findByUsername(username);
        CustomUserDetalis userDetalis = null;
        if (user!=null){
            userDetalis= new CustomUserDetalis();
            userDetalis.setUser(user);
        }else {
            throw new UsernameNotFoundException("User not exist with name:"+username);
        }

        return null;
    }
}
