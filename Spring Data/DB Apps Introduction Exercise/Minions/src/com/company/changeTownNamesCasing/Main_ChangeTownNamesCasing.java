package com.company.changeTownNamesCasing;

import com.company.loginProps.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_ChangeTownNamesCasing {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter username: ");
        String username = scanner.nextLine();
        System.out.print("Please enter password: ");
        String password = scanner.nextLine();

        Connection connection = new Login(username, password).loginStart();
        System.out.print("Enter country: ");
        String countryInput = scanner.nextLine();

        Integer countUpdatedTowns = getCountUpdatedTowns(connection, countryInput);
        if (countUpdatedTowns == null) return;

        String newSelectTownsQuery = "SELECT * FROM `towns` WHERE `country` = ?";
        PreparedStatement selectNewTowns = connection.prepareStatement(newSelectTownsQuery);
        selectNewTowns.setString(1, countryInput);
        ResultSet uppercaseTownsResultSet = selectNewTowns.executeQuery();

        System.out.printf("%d town names were affected.%n", countUpdatedTowns);

        List<String> townsToUppercase = new ArrayList<>();

        while (uppercaseTownsResultSet.next()) {
            townsToUppercase.add(uppercaseTownsResultSet.getString("name"));
        }
        connection.close();

        System.out.println("[" + String.join(", ", townsToUppercase) + "]");
    }

    private static Integer getCountUpdatedTowns(Connection connection, String countryInput) throws SQLException {
        String townsToUppercaseQuery = "UPDATE `towns` " +
                "SET `name` = UPPER(`name`) " +
                "WHERE `country` = ?";
        PreparedStatement updateTownNamesUppercase = connection.prepareStatement(townsToUppercaseQuery);
        updateTownNamesUppercase.setString(1, countryInput);
        int countUpdatedTowns = updateTownNamesUppercase.executeUpdate();

        if (countUpdatedTowns == 0) {
            System.out.println("No town names were affected.");
            return null;
        }
        return countUpdatedTowns;
    }
}
