package com.niroshan.backend.controller;

import com.niroshan.backend.model.User;
import com.niroshan.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/test")
public class GsController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/gs/add")
    public String addFamilyByGs(@RequestBody User user){
        String pwd=user.getPassword();
        String encrtyPwd= passwordEncoder.encode(pwd);
        user.setPassword(encrtyPwd);
        userRepository.save(user);
        return "added successfully....";
    }
}
