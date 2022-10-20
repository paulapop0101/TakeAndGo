package com.takeandgo.takeandgo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private String firstname;
    private String lastname;
    private String email;
}
