package com.takeandgo.takeandgo.mappers;

import com.takeandgo.takeandgo.dtos.UserDTO;
import com.takeandgo.takeandgo.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDTO toDTO(User user);
    User toModel(UserDTO userDTO);
    List<UserDTO> toDTO(List<User> users);
}
