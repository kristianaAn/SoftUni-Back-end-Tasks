package lection_14_AssociativeArrays_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> usernameAndPoints = new LinkedHashMap<>();
        Map<String, Integer> languageAndSubmissions = new LinkedHashMap<>();
        while (!input.equals("exam finished")) {
            //{username}-{language}-{points}
            //{username}-banned

            if (input.contains("banned")) {
                String username = input.split("-")[0];
                usernameAndPoints.remove(username);
            } else {
                String username = input.split("-")[0];
                String language = input.split("-")[1];
                int points = Integer.parseInt(input.split("-")[2]);

                if (!usernameAndPoints.containsKey(username)) {
                    usernameAndPoints.put(username, points);
                } else {
                    int previousValue = usernameAndPoints.get(username);
                    if (previousValue < points) {
                        usernameAndPoints.put(username, points);
                    }
                }

                if (!languageAndSubmissions.containsKey(language)) {
                    languageAndSubmissions.put(language, 1);
                } else {
                    languageAndSubmissions.put(language, languageAndSubmissions.get(language) + 1);
                }
            }

            input = scanner.nextLine();
        }
        System.out.println("Results:");
        usernameAndPoints.entrySet().forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));
        System.out.println("Submissions:");
        languageAndSubmissions.entrySet().forEach(entryLan -> System.out.println(entryLan.getKey() + " - " + entryLan.getValue()));
    }
}
