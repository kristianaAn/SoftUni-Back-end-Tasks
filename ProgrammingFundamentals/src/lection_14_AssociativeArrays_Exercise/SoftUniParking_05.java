package lection_14_AssociativeArrays_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> userAndPlate = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String inputCommand = scanner.nextLine();

            if (inputCommand.contains("unregister")) {
                String username = inputCommand.split(" ")[1];
                if (!userAndPlate.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found%n", username);
                } else {
                    userAndPlate.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                }
            } else if (inputCommand.contains("register")) {
                String username = inputCommand.split(" ")[1];
                String licensePlate = inputCommand.split(" ")[2];

                if (!userAndPlate.containsKey(username)) {
                    userAndPlate.put(username, licensePlate);
                    System.out.printf("%s registered %s successfully%n", username, licensePlate);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", userAndPlate.get(username));
                }

            }
        }
        userAndPlate.entrySet().forEach(entry -> System.out.printf("%s => %s%n", entry.getKey(), entry.getValue()));
    }
}
