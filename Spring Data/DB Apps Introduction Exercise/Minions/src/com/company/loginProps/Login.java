package com.company.loginProps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Login extends Properties {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Connection loginStart() throws SQLException {
        Login login = new Login(username, password);
        login.setProperty("user", username);
        login.setProperty("password", password);

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", login);
    }
}
