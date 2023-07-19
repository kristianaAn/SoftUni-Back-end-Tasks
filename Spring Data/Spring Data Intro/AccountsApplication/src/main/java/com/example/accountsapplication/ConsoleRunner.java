package com.example.accountsapplication;

import com.example.accountsapplication.models.User;
import com.example.accountsapplication.services.AccountService;
import com.example.accountsapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private AccountService accountService;
    private UserService userService;

    @Autowired
    public ConsoleRunner(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
//        userService.registerUser(new User("heUser", 29));
        accountService.withdrawMoney(BigDecimal.valueOf(50000), 2L);
    }
}
