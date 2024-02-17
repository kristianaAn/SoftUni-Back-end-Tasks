package com.softuni.mobilele.validations.loginUserMatcher;

import com.softuni.mobilele.domain.dtos.LoginUserDTO;
import com.softuni.mobilele.domain.entities.User;
import com.softuni.mobilele.repositories.UsersRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class LoginUserValidator implements ConstraintValidator<LoginUserMatcher, LoginUserDTO> {
    private final UsersRepository usersRepository;

    @Autowired
    public LoginUserValidator(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;

    }

    @Override
    public void initialize(LoginUserMatcher constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LoginUserDTO loginUserDTO, ConstraintValidatorContext constraintValidatorContext) {
        Optional<User> optionalUser = this.usersRepository.findByUsername(loginUserDTO.getUsername());

        return optionalUser.isPresent() && loginUserDTO.getPassword().equals(optionalUser.get().getPassword());
    }
}
