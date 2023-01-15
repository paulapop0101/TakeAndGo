package com.takeandgo.takeandgo.validations;

import com.takeandgo.takeandgo.dtos.LogUserDTO;
import com.takeandgo.takeandgo.dtos.UserCreateDTO;
import com.takeandgo.takeandgo.exceptions.EntityException;
import com.takeandgo.takeandgo.models.User;
import com.takeandgo.takeandgo.repositories.UserRepository;
import com.takeandgo.takeandgo.utils.MessageUtil;
import com.takeandgo.takeandgo.utils.PasswordUtil;

public class UserValidation {
    private final UserRepository userRepository;

    public UserValidation(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void userCreateValidation(final UserCreateDTO userCreateDTO){
        checkNull(userCreateDTO);
        checkEmpty(userCreateDTO);
        checkEmail(userCreateDTO);
        if(!userCreateDTO.getPassword().equals(userCreateDTO.getCheckPassword()))
            throw new EntityException(MessageUtil.getMessage("api.error.password.not.match", null));
        checkPassword(userCreateDTO.getPassword());
    }
    public User userLoginValidation(final LogUserDTO logUserDTO){
        checkLogNull(logUserDTO);
        checkLogEmpty(logUserDTO);

        User user = userRepository.findByEmail(logUserDTO.getEmail());
        if(user == null)
            throw new EntityException(MessageUtil.getMessage("api.error.email",null));
        if(!user.getPassword().equals(PasswordUtil.getMd5(logUserDTO.getPassword())))
            throw new EntityException(MessageUtil.getMessage("api.error.wrong.password",null));
        return user;
    }

    private void checkLogEmpty(final LogUserDTO logUserDTO) {
        if(logUserDTO.getEmail().isEmpty() || logUserDTO.getPassword().isEmpty())
            throw new EntityException(MessageUtil.getMessage("api.error.empty.fields", null));
    }

    private void checkLogNull(final LogUserDTO logUserDTO) {
        if(logUserDTO.getEmail()==null || logUserDTO.getPassword()==null)
            throw new EntityException(MessageUtil.getMessage("api.error.empty.fields", null));
    }

    private void checkNull(final UserCreateDTO userCreationDTO) {
        if(userCreationDTO.getFirstname()==null || userCreationDTO.getLastname()==null ||
                userCreationDTO.getEmail()==null || userCreationDTO.getPassword()==null ||
                userCreationDTO.getCheckPassword()==null)
            throw new EntityException(MessageUtil.getMessage("api.error.empty.fields", null));
    }

    private void checkEmail(final UserCreateDTO userCreationDTO) {
        for(final User user : userRepository.findAll())
            if(user.getEmail().equals(userCreationDTO.getEmail()))
                throw new EntityException(MessageUtil.getMessage("api.error.duplicate", new Object[]{"Account","email"}));
    }

    public void checkPassword(final String password) {
        boolean uppercase=false;
        if(password.length()<8)
            throw new EntityException(MessageUtil.getMessage("api.error.password.format", null));
        for(int i=0;i<password.length();i++) {
            if(Character.isUpperCase(password.charAt(i)))
                uppercase=true;
            if(Character.isSpaceChar(password.charAt(i)))
                throw new EntityException(MessageUtil.getMessage("api.error.password.format", null));
        }
        if(!uppercase)
            throw new EntityException(MessageUtil.getMessage("api.error.password.format", null));
    }

    private void checkEmpty(final UserCreateDTO userCreationDTO) {
        if(userCreationDTO.getFirstname().isEmpty() || userCreationDTO.getLastname().isEmpty() ||
                userCreationDTO.getEmail().isEmpty() ||
                userCreationDTO.getPassword().isEmpty() || userCreationDTO.getCheckPassword().isEmpty())
            throw new EntityException(MessageUtil.getMessage("api.error.empty.fields", null));
    }
}
