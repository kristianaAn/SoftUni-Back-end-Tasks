package com.company.increaseAgeStoredProcedure;

import com.company.loginProps.Login;

import java.sql.*;
import java.util.Scanner;

public class Main_IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter username: ");
        String username = scanner.nextLine();
        System.out.print("Please enter password: ");
        String password = scanner.nextLine();

        Connection connection = new Login(username,password).loginStart();

        System.out.print("Enter Minion_ID: ");
        int minionIDInput = Integer.parseInt(scanner.nextLine());

        handleProcedureQuery(connection, minionIDInput);

        String newAgeQuery = "SELECT `name`, `age` FROM `minions` WHERE `id` = ?";
        PreparedStatement updatedAgeSelect = connection.prepareStatement(newAgeQuery);
        updatedAgeSelect.setInt(1, minionIDInput);
        ResultSet updatedResultSet = updatedAgeSelect.executeQuery();

        while (updatedResultSet.next()) {
            System.out.printf("%s %s", updatedResultSet.getString("name"), updatedResultSet.getInt("age"));
        }
        connection.close();
    }

    private static void handleProcedureQuery(Connection connection, int minionIDInput) throws SQLException {
        String getOlderProcedureQuery = "{CALL usp_get_older(?)}";
        CallableStatement callGetOlderProcedure = connection.prepareCall(getOlderProcedureQuery);
        callGetOlderProcedure.setInt(1, minionIDInput);
        callGetOlderProcedure.executeQuery();
    }
}
