package com.takeandgo.takeandgo.services;

import com.takeandgo.takeandgo.dtos.LogUserDTO;
import com.takeandgo.takeandgo.dtos.UserCreateDTO;
import com.takeandgo.takeandgo.dtos.UserDTO;
import com.takeandgo.takeandgo.exceptions.EntityException;
import com.takeandgo.takeandgo.mappers.UserMapper;
import com.takeandgo.takeandgo.models.User;
import com.takeandgo.takeandgo.repositories.UserRepository;
import com.takeandgo.takeandgo.utils.PasswordUtil;
import com.takeandgo.takeandgo.validations.UserValidation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserValidation userValidation;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    public UserService(final UserRepository userRepository){
        this.userRepository=userRepository;
        this.userValidation = new UserValidation(userRepository);
    }

    public List<UserDTO> getAllUsers(){
        return userMapper.toDTO(userRepository.findAll());

    }
    public UserDTO addUser(final UserCreateDTO userCreateDTO){
        userValidation.userCreateValidation(userCreateDTO);
        User user = userMapper.toModel(userCreateDTO);
        user.setPassword(PasswordUtil.getMd5(user.getPassword()));
        userRepository.save(user);
        user = userRepository.findByEmail(userCreateDTO.getEmail());
        return userMapper.toDTO(user);
    }

    public UserDTO loginUser(final LogUserDTO userDTO) {
        User user = userValidation.userLoginValidation(userDTO);
        return userMapper.toDTO(user);
    }

    public Boolean updateUser(final UserDTO user) {
        User user1 = userRepository.findById(user.getId());
        user1.setFirstname(user.getFirstname());
        user1.setLastname(user.getLastname());
        user1.setEmail(user.getEmail());
        userRepository.save(user1);
        return true;
    }
}
