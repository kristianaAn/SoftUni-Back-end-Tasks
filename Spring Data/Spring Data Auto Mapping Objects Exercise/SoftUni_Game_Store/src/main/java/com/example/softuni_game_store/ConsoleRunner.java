package com.example.softuni_game_store;

import com.example.softuni_game_store.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.example.softuni_game_store.constants.Constants.CLOSE;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;

    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals(CLOSE)) {
            String[] strings = input.split("\\|");
            String command = strings[0];

            switch (command) {
                case "RegisterUser":
                    String email = strings[1];
                    String password = strings[2];
                    String confirmPassword = strings[3];
                    String fullName = strings[4];

                    userService.registerUser(email, password, confirmPassword, fullName);
//                    registerUser(email, password, confirmPassword, fullName);
                    break;
                case "LoginUser":
                    break;
                case "Logout":
                    break;
            }

            input = scanner.nextLine();
        }

    }

}
