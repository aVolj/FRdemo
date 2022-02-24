package com.volodichev.frdemo.controller;

import com.volodichev.frdemo.entity.Survey;
import com.volodichev.frdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Set;

@RestController
@RequestMapping(value = "/api/user/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "detailed-answer/{id}")
    public Set<Survey> getAllDetailedAnswer(@PathVariable long id){
        return userService.getAllDetailedAnswer(id);
    }

}
