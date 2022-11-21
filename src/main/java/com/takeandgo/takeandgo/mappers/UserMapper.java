package com.takeandgo.takeandgo.mappers;

import com.takeandgo.takeandgo.dtos.UserCreateDTO;
import com.takeandgo.takeandgo.dtos.UserDTO;
import com.takeandgo.takeandgo.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDTO toDTO(User user);
    User toModel(UserCreateDTO userCreateDTO);
    List<UserDTO> toDTO(List<User> users);
}
