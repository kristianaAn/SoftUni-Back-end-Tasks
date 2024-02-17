package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.dtos.LoginUserDTO;
import com.softuni.mobilele.domain.dtos.UserDTO;

public interface UserService {
    UserDTO saveUserRegistrationInfo(UserDTO userDTO);

    void loginUser(LoginUserDTO loginUser);

    void logout();
}
