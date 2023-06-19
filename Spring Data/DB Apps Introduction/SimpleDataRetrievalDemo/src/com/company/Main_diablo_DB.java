package com.company;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main_diablo_DB {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username default (root): ");
        String user = scanner.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.println();

        System.out.print("Enter password default (empty):");
        String password = scanner.nextLine().trim();
        System.out.println();

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/diablo", properties);

        String query = "SELECT u.first_name, u.last_name, COUNT(ug.id) AS 'count' " +
                       "FROM users AS u " +
                       "JOIN users_games AS ug ON ug.user_id = u.id " +
                       "WHERE u.user_name = ? " +
                       "GROUP BY u.id";

        PreparedStatement prepStmt = connection.prepareStatement(query);
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        prepStmt.setString(1, userName);
        ResultSet result = prepStmt.executeQuery();

            if (result.next()) {
                System.out.printf("User: %s%n%s %s has played %d games", userName,
                        result.getString("first_name"), result.getString("last_name"), result.getInt("count"));
            } else {
                System.out.println("No such user exists");
            }

        connection.close();
    }
}
