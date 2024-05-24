package com.course.exceptions.four_proyect.controllers;

import com.course.exceptions.four_proyect.Models.domain.User;
import com.course.exceptions.four_proyect.excepitions.UserNotFoundException;
import com.course.exceptions.four_proyect.services.IUserService;
import jakarta.servlet.http.PushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    private IUserService userService;
    @GetMapping
    public String index(){
        int value = 100 / 0;
        return "ok 200";
    }
    @GetMapping("/show/{id}")
    public User findById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);
        if(user==null){
            throw new UserNotFoundException("User not found");
        }
        return user;
    }
}
