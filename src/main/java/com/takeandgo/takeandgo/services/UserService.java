package com.takeandgo.takeandgo.services;

import com.takeandgo.takeandgo.dtos.UserCreateDTO;
import com.takeandgo.takeandgo.dtos.UserDTO;
import com.takeandgo.takeandgo.mappers.UserMapper;
import com.takeandgo.takeandgo.models.User;
import com.takeandgo.takeandgo.repositories.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    public UserService(final UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<UserDTO> getAllUsers(){
        return userMapper.toDTO(userRepository.findAll());

    }
    public void addUser(final UserCreateDTO userCreateDTO){
        User user = userMapper.toModel(userCreateDTO);
        userRepository.save(user);
    }
}
