package com.takeandgo.takeandgo.controllers;

import com.takeandgo.takeandgo.dtos.ChangePasswordDTO;
import com.takeandgo.takeandgo.dtos.LogUserDTO;
import com.takeandgo.takeandgo.dtos.UserCreateDTO;
import com.takeandgo.takeandgo.dtos.UserDTO;
import com.takeandgo.takeandgo.models.User;
import com.takeandgo.takeandgo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <List<UserDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping("/addUser")
    public ResponseEntity <UserDTO> addUser(@RequestBody final UserCreateDTO userCreateDTO){
        return new ResponseEntity<>( userService.addUser(userCreateDTO),HttpStatus.OK);
    }
    @PostMapping("/loginUser")
    public ResponseEntity <UserDTO> loginUser(@RequestBody final LogUserDTO user){
        return new ResponseEntity<>( userService.loginUser(user),HttpStatus.OK);
    }
    @PutMapping("/updateUserr")
    public ResponseEntity <UserDTO> updateUser(@RequestBody final UserDTO user){
        return new ResponseEntity<>( userService.updateUser(user),HttpStatus.OK);
    }

    @PutMapping("/changePassword")
    public ResponseEntity <Boolean> changePassword(@RequestBody final ChangePasswordDTO changePasswordDTO){
        return new ResponseEntity<>( userService.changePassword(changePasswordDTO),HttpStatus.OK);
    }

}
