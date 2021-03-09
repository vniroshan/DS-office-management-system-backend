package com.niroshan.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noAuth/rest")
public class NoAuthController {

    @GetMapping("/sayHI")
    public String sayHi(){
        return "hi";
    }
}
