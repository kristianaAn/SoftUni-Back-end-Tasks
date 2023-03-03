package lection_06_SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, String> phonebook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String phoneNumber = input.split("-")[1];

            phonebook.put(name, phoneNumber);

            input = scanner.nextLine();
        }

        String inputText = scanner.nextLine();

        while (!inputText.equals("stop")) {

            if (phonebook.containsKey(inputText)) {
                System.out.printf("%s -> %s%n", inputText, phonebook.get(inputText));
            } else {
                System.out.printf("Contact %s does not exist.%n", inputText);
            }

            inputText = scanner.nextLine();
        }
    }
}
