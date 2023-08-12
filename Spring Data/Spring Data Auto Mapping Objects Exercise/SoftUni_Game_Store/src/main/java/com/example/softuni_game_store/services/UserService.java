package com.example.softuni_game_store.services;

public interface UserService {
    String registerUser(String email, String password, String confirmPassword, String fullName);
}
