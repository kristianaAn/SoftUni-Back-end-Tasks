package com.example.accountsapplication.services;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.example.accountsapplication.models.User;
import com.example.accountsapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        User byUsername = userRepository.findByUsername(user.getUsername());

        if (byUsername != null) {
            throw new IllegalArgumentException("User already exists");
        }

        userRepository.save(user);
    }
}
