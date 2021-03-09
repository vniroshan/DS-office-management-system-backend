package com.niroshan.backend.controller;

import com.niroshan.backend.model.Family;
import com.niroshan.backend.model.Login;
import com.niroshan.backend.repository.LoginRepository;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/rest/auth/")
public class ApplicationController {

    @GetMapping("/process")
    public String process(){
        return "processing....";
    }




}
