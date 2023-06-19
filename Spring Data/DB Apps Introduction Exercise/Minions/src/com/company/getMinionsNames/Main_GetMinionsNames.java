package com.company.getMinionsNames;

import com.company.loginProps.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main_GetMinionsNames {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter username: ");
        String username = scanner.nextLine();
        System.out.print("Please enter password: ");
        String password = scanner.nextLine();

        Connection connection = new Login(username, password).loginStart();
        String mySQLQuery = "SELECT m.`name` AS `minion_name`, m.`age` AS `minion_age` FROM `minions` AS m " +
                            "JOIN `minions_villains` AS mv ON mv.`minion_id` = m.`id` " +
                            "JOIN `villains` AS v ON v.`id` = mv.`villain_id` " +
                            "WHERE v.`id` = ?";
        PreparedStatement prepStmtAllMinions = connection.prepareStatement(mySQLQuery);

        String villainNameQuery = "SELECT `name` FROM `villains` " +
                                  "WHERE `id` = ?";
        PreparedStatement prepStmtVillainName = connection.prepareStatement(villainNameQuery);

        System.out.print("Enter Villain ID: ");
        int villainId = Integer.parseInt(scanner.nextLine());

        prepStmtAllMinions.setInt(1, villainId);
        prepStmtVillainName.setInt(1, villainId);

        ResultSet resultSetVillains = prepStmtVillainName.executeQuery();
        if (!resultSetVillains.next()) {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
            return;
        }

        ResultSet resultSetMinions = prepStmtAllMinions.executeQuery();
        int rowCounter = 1;


        System.out.printf("Villain: %s%n", resultSetVillains.getString("name"));
        while (resultSetMinions.next()) {
            System.out.printf("%d. %s %d%n",
                    rowCounter,
                    resultSetMinions.getString("minion_name"),
                    resultSetMinions.getInt("minion_age"));
            rowCounter++;
        }
        connection.close();

    }
}
