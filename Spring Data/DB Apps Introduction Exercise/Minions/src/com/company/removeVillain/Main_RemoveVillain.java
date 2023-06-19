package com.company.removeVillain;

import com.company.loginProps.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main_RemoveVillain {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter username: ");
        String username = scanner.nextLine();
        System.out.print("Please enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Villain ID: ");
        int villainId = Integer.parseInt(scanner.nextLine());

        Connection connection = new Login(username, password).loginStart();

        connection.setAutoCommit(false);

        ResultSet villainSelectResult = getVillainSelectResult(villainId, connection);
        if (villainSelectResult == null) return;

        try {
            int deletedMinionsCount = getDeletedMinionsCount(villainId, connection);

            deleteVillain(villainId, connection);

            connection.commit();

            System.out.printf("%s was deleted%n", villainSelectResult.getString("name"));
            System.out.printf("%d minions released", deletedMinionsCount);

        } catch (SQLException e) {
            connection.rollback();
        }
        connection.close();
    }

    private static void deleteVillain(int villainId, Connection connection) throws SQLException {
        String deleteFromVillains = "DELETE FROM `villains` WHERE `id` = ?";
        PreparedStatement deleteVillain = connection.prepareStatement(deleteFromVillains);
        deleteVillain.setInt(1, villainId);
        deleteVillain.executeUpdate();
    }

    private static int getDeletedMinionsCount(int villainId, Connection connection) throws SQLException {
        String deleteMinionIDs = "DELETE FROM `minions_villains` WHERE `villain_id` = ?";
        PreparedStatement deleteMinions = connection.prepareStatement(deleteMinionIDs);
        deleteMinions.setInt(1, villainId);
        int deletedMinionsCount = deleteMinions.executeUpdate();
        return deletedMinionsCount;
    }

    private static ResultSet getVillainSelectResult(int villainId, Connection connection) throws SQLException {
        String selectVillainQuery = "SELECT `name` FROM `villains` WHERE `id` = ?";
        PreparedStatement villainValidation = connection.prepareStatement(selectVillainQuery);
        villainValidation.setInt(1, villainId);
        ResultSet villainSelectResult = villainValidation.executeQuery();
        if (!villainSelectResult.next()) {
            System.out.println("No such villain was found");
            return null;
        }
        return villainSelectResult;
    }
}
