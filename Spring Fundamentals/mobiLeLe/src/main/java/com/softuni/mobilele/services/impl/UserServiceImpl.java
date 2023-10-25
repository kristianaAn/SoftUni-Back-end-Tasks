package com.softuni.mobilele.services.impl;

import com.softuni.mobilele.domain.dtos.UserDTO;
import com.softuni.mobilele.domain.entities.User;
import com.softuni.mobilele.repositories.UsersRepository;
import com.softuni.mobilele.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UsersRepository usersRepository;
    private ModelMapper modelMapper;

    public UserServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    public void saveUserRegistrationInfo(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        this.usersRepository.saveAndFlush(user);
    }
}
