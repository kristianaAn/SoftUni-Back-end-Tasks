package com.softuni.mobilele.services.impl;

import com.softuni.mobilele.domain.beans.LoggedUser;
import com.softuni.mobilele.domain.dtos.LoginUserDTO;
import com.softuni.mobilele.domain.dtos.UserDTO;
import com.softuni.mobilele.domain.entities.User;
import com.softuni.mobilele.repositories.UsersRepository;
import com.softuni.mobilele.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    private UsersRepository usersRepository;
    private ModelMapper modelMapper;
    private LoggedUser loggedUser;

    public UserServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    @Override
    public UserDTO saveUserRegistrationInfo(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setActive(true);
        user.setCreated(Date.from(Instant.now()));
        User savedAndFlushed = this.usersRepository.saveAndFlush(user);
        return modelMapper.map(savedAndFlushed, UserDTO.class);
    }

    @Override
    public void loginUser(LoginUserDTO loginUser) {

        UserDTO mapped = this.modelMapper
                .map(this.usersRepository.findByUsername(loginUser.getUsername()).get(), UserDTO.class);

        this.loggedUser.setId(mapped.getId());
            this.loggedUser.setUsername(mapped.getUsername());
            this.loggedUser.setFirstName(mapped.getFirstName());
            this.loggedUser.setRole(String.valueOf(mapped.getRole()));

    }

    @Override
    public void logout(){
        this.loggedUser.clearFieldsData();
    }
}
