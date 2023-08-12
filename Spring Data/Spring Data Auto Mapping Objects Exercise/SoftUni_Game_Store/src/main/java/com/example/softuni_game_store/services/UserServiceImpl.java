package com.example.softuni_game_store.services;

import com.example.softuni_game_store.dtos.UserRegisterDto;
import com.example.softuni_game_store.entities.User;
import com.example.softuni_game_store.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static com.example.softuni_game_store.constants.Constants.DUPLICATE_EMAIL;
import static com.example.softuni_game_store.constants.Constants.SUCCESSFUL_REGISTRATION;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.modelMapper = new ModelMapper();
    }


    @Override
    public String registerUser(String email, String password, String confirmPassword, String fullName) {
        boolean isAdmin = validateAdminStatus();
        UserRegisterDto userRegisterDto;

        if (this.usersRepository.findFirstByEmail(email) != null) {
            return DUPLICATE_EMAIL;
        }

        try {
            userRegisterDto = new UserRegisterDto(email, password, confirmPassword, fullName);
            User mappedUser = modelMapper.map(userRegisterDto, User.class);
            if (isAdmin) {
                mappedUser.setAdmin(true);
            } else {
                mappedUser.setAdmin(false);
            }
            this.usersRepository.saveAndFlush(mappedUser);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return String.format(SUCCESSFUL_REGISTRATION, fullName);
    }

    private boolean validateAdminStatus() {
        boolean isAdmin = true;
        if (usersRepository.count() > 0) {
            isAdmin = false;
        }
        return isAdmin;
    }
}
