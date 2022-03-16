package com.bridgelabz.bookstorebackend.controller;


import com.bridgelabz.bookstorebackend.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("bookstore")
public class UserController {

    List<User> users =  new ArrayList<>();

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public User getUSerById(@PathVariable int id){
        return users.get(id-1);
    }

    @PostMapping("/create")
    public List<User> addUser(@RequestBody User user){
        users.add(user);
        return users;

    }

}
