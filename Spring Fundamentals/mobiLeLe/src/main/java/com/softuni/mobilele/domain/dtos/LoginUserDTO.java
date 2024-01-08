package com.softuni.mobilele.domain.dtos;

import jakarta.validation.constraints.NotNull;

public class LoginUserDTO {
    private String username;
    private String password;

    public LoginUserDTO() {
    }

    public LoginUserDTO(long id, String username, String password) {
        this.username = username;
        this.password = password;
    }


    @NotNull
    public String getUsername() {
        return username;
    }

    public LoginUserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public LoginUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
