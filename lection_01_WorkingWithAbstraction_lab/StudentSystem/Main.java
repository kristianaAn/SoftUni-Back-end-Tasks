package lection_01_WorkingWithAbstraction_lab.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String inputLine = scanner.nextLine();

        while (!inputLine.equals("Exit")) {
            String[] input = inputLine.split("\\s+");
            String command = input[0];
            if (command.contains("Create")) {
                String name = input[1];
                int age = Integer.parseInt(input[2]);
                double grade = Double.parseDouble(input[3]);

                studentSystem.create(name, age, grade);
            } else if (command.contains("Show")) {
                String name = input[1];

                studentSystem.show(name);
            }

            inputLine = scanner.nextLine();
        }
    }
}
