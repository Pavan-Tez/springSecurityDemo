package com.sec.springSecurityDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcomeAll(){
        return "<h1> Welcome all!! </h1>";
    }

    @GetMapping("/user")
    public String welcomeUser(){
        return "<h1> Welcome User!! </h1>";
    } 
    @GetMapping("/admin")
    public String welcomeAdmin(){
        return "<h1> Welcome Admin!! </h1>";
    }
  
}
