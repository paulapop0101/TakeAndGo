package com.takeandgo.takeandgo.controllers;

import com.takeandgo.takeandgo.models.User;
import com.takeandgo.takeandgo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService){
        this.userService=userService;
    }

    @GetMapping("/getUsers")
    public ResponseEntity <List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping("/addUser")
    public ResponseEntity <Boolean> addUser(@RequestBody final User user){
        userService.addUser(user);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
