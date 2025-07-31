package com.mic.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mic.user.entities.User;
import com.mic.user.services.UserService;



@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        User response = userService.saveUser(user);
        return response;
    }
    
    @GetMapping("{id}")
    public User getUserById(@PathVariable String id) {
        User user  = userService.getUserById(id);
        return user;
    }

    @GetMapping()
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }
    
}
