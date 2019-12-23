package com.example.demo_baufest.resource;

import com.example.demo_baufest.model.User;
import com.example.demo_baufest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;


    @PostMapping
    @ResponseBody
    public User createUser (@RequestBody @Valid User user){
        return userService.createUser(user);
    }

}

