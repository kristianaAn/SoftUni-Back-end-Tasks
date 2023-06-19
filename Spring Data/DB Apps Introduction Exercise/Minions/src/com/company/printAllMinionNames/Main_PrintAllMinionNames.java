package com.company.printAllMinionNames;

import com.company.loginProps.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter username: ");
        String username = scanner.nextLine();
        System.out.print("Please enter password: ");
        String password = scanner.nextLine();

        Connection connection = new Login(username, password).loginStart();

        String minionNamesSelectQuery = "SELECT `name` FROM `minions`";
        PreparedStatement selectMinionNames = connection.prepareStatement(minionNamesSelectQuery);
        ResultSet resultSet = selectMinionNames.executeQuery();
        List<String> minionNamesList = new ArrayList<>();

        while (resultSet.next()) {
            minionNamesList.add(resultSet.getString("name"));
        }
        connection.close();

        printMinions(minionNamesList);
    }

    private static void printMinions(List<String> minionNamesList) {
        int plusCount = 0;
        int minusCount = minionNamesList.size() - 1;

        for (int i = 0; i < minionNamesList.size() / 2; i++) {
            System.out.println(minionNamesList.get(plusCount));
            plusCount++;
            System.out.println(minionNamesList.get(minusCount));
            minusCount--;
        }
    }
}
