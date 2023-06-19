package com.company.getVillainsNames;

import com.company.loginProps.Login;

import java.sql.*;
import java.util.Scanner;

public class Main_GetVillainsNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter username: ");
        String username = scanner.nextLine();
        System.out.print("Please enter password: ");
        String password = scanner.nextLine();


        Connection connection = new Login(username, password).loginStart();
        String mySQLQuery = "SELECT " +
                "v.`name` AS 'villain_name', " +
                "COUNT(DISTINCT m.`id`) AS 'minions_count' " +
                "FROM " +
                "`minions` AS m " +
                "JOIN " +
                "`minions_villains` AS mv ON mv.`minion_id` = m.`id` " +
                "JOIN " +
                "`villains` AS v ON v.`id` = mv.`villain_id` " +
                "GROUP BY v.`id` " +
                "HAVING `minions_count` > 15 " +
                "ORDER BY `minions_count` DESC";

        PreparedStatement mySQLstmt = connection.prepareStatement(mySQLQuery);

        ResultSet resultSet = mySQLstmt.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("villain_name"),
                                         resultSet.getInt("minions_count"));
        }
        connection.close();
    }
}
