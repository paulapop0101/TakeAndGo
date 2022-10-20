package com.takeandgo.takeandgo.services;

import com.takeandgo.takeandgo.models.User;
import com.takeandgo.takeandgo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public void addUser(final User user){
        userRepository.save(user);
    }
}
