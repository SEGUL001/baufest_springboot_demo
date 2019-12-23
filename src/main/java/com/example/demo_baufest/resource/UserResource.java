package com.example.demo_baufest.resource;

import com.example.demo_baufest.model.User;
import com.example.demo_baufest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    @ResponseBody
    public ResponseEntity updateUser(@RequestBody @Valid User user){
        return userService.updateUser(user);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity deleteUser(@RequestBody @Valid User user){
        return userService.deleteUser(user);
    }
}

