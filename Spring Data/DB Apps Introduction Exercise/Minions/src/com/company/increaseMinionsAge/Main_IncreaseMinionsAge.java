package com.company.increaseMinionsAge;

import com.company.loginProps.Login;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main_IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter username: ");
        String username = scanner.nextLine();
        System.out.print("Please enter password: ");
        String password = scanner.nextLine();
        Connection connection = new Login(username, password).loginStart();

        System.out.print("Enter Minion IDs: ");
        List<Integer> inputIDs = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String selectMinionsToUpdateQuery = String.format("SELECT * FROM `minions` WHERE `id` IN (%s)",
                                             getIDsCollection(inputIDs));
        PreparedStatement selectMinions = connection.prepareStatement(selectMinionsToUpdateQuery);

        replacePlaceholders(inputIDs, selectMinions);

        ResultSet allMinionsSelectedResultSet = selectMinions.executeQuery();

        if (allMinionsSelectedResultSet.next()) {
            updateMinionsAge(connection, inputIDs);
            updateMinionsNames(connection, inputIDs);
        }

        String updatedMinionsForPrintQuery = "SELECT `name`, `age` FROM `minions`";
        PreparedStatement updatedMinionsToPrint = connection.prepareStatement(updatedMinionsForPrintQuery);
        ResultSet resultSet = updatedMinionsToPrint.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("age"));
        }
        connection.close();
    }

    private static void updateMinionsNames(Connection connection, List<Integer> inputIDs) throws SQLException {
        String lowerNamesQuery = String.format("UPDATE `minions` SET `name` = LOWER(`name`) " +
                "WHERE `id` IN (%s)", getIDsCollection(inputIDs));
        PreparedStatement lowerMinionNames = connection.prepareStatement(lowerNamesQuery);
        replacePlaceholders(inputIDs, lowerMinionNames);
        lowerMinionNames.executeUpdate();
    }

    private static void updateMinionsAge(Connection connection, List<Integer> inputIDs) throws SQLException {
        String updateAgeQuery = String.format("UPDATE `minions` SET `age` = `age` + 1 " +
                "WHERE `id` IN (%s)", getIDsCollection(inputIDs));
        PreparedStatement updateMinionAge = connection.prepareStatement(updateAgeQuery);
        replacePlaceholders(inputIDs, updateMinionAge);
        updateMinionAge.executeUpdate();
    }

    private static void replacePlaceholders(List<Integer> inputIDs, PreparedStatement selectMinions) throws SQLException {
        int index = 1;
        for (Integer id : inputIDs) {
            selectMinions.setInt(index++, id);
        }
    }

    private static String getIDsCollection(List<Integer> inputIDs) {
        return inputIDs.stream().map(v -> "?")
                .collect(Collectors.joining(", "));
    }
}
