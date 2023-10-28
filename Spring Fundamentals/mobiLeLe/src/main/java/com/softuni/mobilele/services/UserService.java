package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.dtos.LoginUserDTO;
import com.softuni.mobilele.domain.dtos.UserDTO;
import com.softuni.mobilele.domain.entities.User;

import java.util.Optional;

public interface UserService {
    void saveUserRegistrationInfo(UserDTO userDTO);

    Optional<User> findUserByCredentials(LoginUserDTO loginUserDTO);
}
