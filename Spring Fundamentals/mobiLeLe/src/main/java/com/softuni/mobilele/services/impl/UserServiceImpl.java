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
import java.util.Optional;

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
    public UserDTO loginUser(LoginUserDTO loginUser) {
        Optional<User> optionalUser = this.usersRepository
                .findByUsername(loginUser.getUsername());

        UserDTO userDTO = optionalUser.isPresent() && optionalUser.get().getPassword().equals(loginUser.getPassword())
                ? modelMapper.map(optionalUser.get(), UserDTO.class)
                : new UserDTO();

        if (userDTO.getId() > 0) {
            this.loggedUser.setId(userDTO.getId());
            this.loggedUser.setUsername(userDTO.getUsername());
            this.loggedUser.setFirstName(userDTO.getFirstName());
            this.loggedUser.setRole(String.valueOf(userDTO.getRole()));
        }

        return userDTO;

    }

    @Override
    public void logout(){
        this.loggedUser.clearFieldsData();
    }
}
