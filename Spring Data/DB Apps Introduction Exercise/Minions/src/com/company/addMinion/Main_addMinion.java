package com.company.addMinion;

import com.company.loginProps.Login;

import java.sql.*;
import java.util.Scanner;

public class Main_addMinion {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter username: ");
        String username = scanner.nextLine();
        System.out.print("Please enter password: ");
        String password = scanner.nextLine();

        Connection connection = new Login(username, password).loginStart();

        System.out.print("Minion: ");
        String[] minionInfo = scanner.nextLine().split(" ");
        String minionName = minionInfo[0];
        int minionAge = Integer.parseInt(minionInfo[1]);
        String minionTown = minionInfo[2];

        System.out.print("Villain: ");
        String villainName = scanner.nextLine();

        int townId = getTownId(connection, minionTown);

        int villainId = getVillainId(connection, villainName);

        handleMinionAssignment(connection, minionName, minionAge, villainName, townId, villainId);

        connection.close();
    }

    private static void handleMinionAssignment(Connection connection, String minionName, int minionAge, String villainName, int townId, int villainId) throws SQLException {
        String insertMinionQuery = "INSERT INTO `minions`(`name`, `age`, `town_id`) VALUES (?, ?, ?)";
        PreparedStatement insertMinion = connection.prepareStatement(insertMinionQuery);
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);
        insertMinion.setInt(3, townId);
        insertMinion.executeUpdate();

        String selectMinionQuery = "SELECT * FROM `minions` WHERE `name` = ?";
        PreparedStatement selectMinionPrepStmt = connection.prepareStatement(selectMinionQuery);
        selectMinionPrepStmt.setString(1, minionName);
        ResultSet selectMinionResult = selectMinionPrepStmt.executeQuery();
        selectMinionResult.next();
        int minionId = selectMinionResult.getInt("id");

        String insertMinionToVillainQuery = "INSERT INTO `minions_villains`(`minion_id`, `villain_id`) VALUES(?, ?)";
        PreparedStatement insertMinionToVillain = connection.prepareStatement(insertMinionToVillainQuery);
        insertMinionToVillain.setInt(1, minionId);
        insertMinionToVillain.setInt(2, villainId);
        insertMinionToVillain.executeUpdate();
        System.out.printf("Successfully added %s to be minion of %s%n", minionName, villainName);
    }

    private static int getVillainId(Connection connection, String villainName) throws SQLException {
        String selectVillainQuery = "SELECT * FROM `villains` WHERE `name` = ?";
        PreparedStatement prepStmtVillainValidation = connection.prepareStatement(selectVillainQuery);
        prepStmtVillainValidation.setString(1, villainName);
        ResultSet villainSelectResult = prepStmtVillainValidation.executeQuery();

        if (!villainSelectResult.next()) {
            String addVillainQuery = "INSERT INTO `villains`(`name`, `evilness_factor`) VALUES(?, 'evil')";
            PreparedStatement addVillain = connection.prepareStatement(addVillainQuery);
            addVillain.setString(1, villainName);
            addVillain.executeUpdate();
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        ResultSet villainNewSelectResult = prepStmtVillainValidation.executeQuery();
        villainNewSelectResult.next();
        return villainNewSelectResult.getInt("id");
    }

    private static int getTownId(Connection connection, String minionTown) throws SQLException {
        String selectTownQuery = "SELECT * FROM `towns` " +
                                 "WHERE `name` = ?";
        PreparedStatement prepStmtTownValidation = connection.prepareStatement(selectTownQuery);
        prepStmtTownValidation.setString(1, minionTown);
        ResultSet resultSetTownValidation = prepStmtTownValidation.executeQuery();

        if (!resultSetTownValidation.next()) {
            String addTownQuery = "INSERT INTO `towns`(`name`) VALUES (?);";
            PreparedStatement addTown = connection.prepareStatement(addTownQuery);
            addTown.setString(1, minionTown);
            addTown.executeUpdate();
            System.out.printf("Town %s was added to the database.%n", minionTown);
        }

        ResultSet newResultSetTown = prepStmtTownValidation.executeQuery();
        newResultSetTown.next();
        return newResultSetTown.getInt("id");
    }
}
