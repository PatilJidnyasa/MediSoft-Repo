package com.siliconmount.MediSoft.controller;

import com.siliconmount.MediSoft.entity.User;
import com.siliconmount.MediSoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class Home {
    @Autowired
    private UserService userService;
    //http://localhost:8080/home/users
    @GetMapping("/users")
    public List<User> getUser(){
        System.out.println("getting users");
        return userService.getUsers();
    }
    @GetMapping("/welcome")
    public String welcome(){
        String text = "hello";
        return text;
    }
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
