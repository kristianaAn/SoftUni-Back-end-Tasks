package lection_06_SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, String> namesAndEmails = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();

            if (!namesAndEmails.containsKey(name) && (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com"))) {
                namesAndEmails.put(name, email);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : namesAndEmails.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
