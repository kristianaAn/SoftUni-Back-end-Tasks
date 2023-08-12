package com.example.softuni_game_store.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

import static com.example.softuni_game_store.constants.Constants.EMAIL_REGEX;
import static com.example.softuni_game_store.constants.Constants.PASSWORD_REGEX;

@NoArgsConstructor
@Getter
public class UserRegisterDto {

    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public UserRegisterDto(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        dataValidation();
    }

    private void dataValidation() {
        if (!Pattern.matches(EMAIL_REGEX, this.email)) {
            throw new IllegalArgumentException("Incorrect email");
        }

        if (!Pattern.matches(PASSWORD_REGEX, this.password)) {
            throw new IllegalArgumentException("Incorrect password");
        }

        if (!this.password.equals(this.confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }

    }

}
