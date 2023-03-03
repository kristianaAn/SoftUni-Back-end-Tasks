package lection_07_InterfacesAndAbstraction_lab.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Robot> robotList = new ArrayList<>();
        List<Citizen> citizenList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] inputData = input.split("\\s+");

            if (inputData.length == 2) {
                String model = inputData[0];
                String id = inputData[1];
                Robot robot = new Robot(model,id);
                robotList.add(robot);

            } else {
                String name = inputData[0];
                int age = Integer.parseInt(inputData[1]);
                String id = inputData[2];
                Citizen citizen = new Citizen(name, age, id);
                citizenList.add(citizen);

            }
            input = scanner.nextLine();
        }

        String fakeIdSuffix = scanner.nextLine();

        for (Citizen citizen : citizenList) {
            if (citizen.getId().endsWith(fakeIdSuffix)) {
                System.out.println(citizen.getId());
            }
        }

        for (Robot robot : robotList) {
            String currentRobotId = robot.getId();
            if (currentRobotId.endsWith(fakeIdSuffix)) {
                System.out.println(robot.getId());
            }
        }

    }
}
