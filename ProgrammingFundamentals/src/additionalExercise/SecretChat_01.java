package additionalExercise;

import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String concealedMessage = scanner.nextLine();
        StringBuilder messageSb = new StringBuilder(concealedMessage);

        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            if (input.contains("InsertSpace")) {
                int index = Integer.parseInt(input.split(":\\|:")[1]);
                messageSb.insert(index, " ");
                System.out.println(messageSb);

            } else if (input.contains("Reverse")) {
                String subString = input.split(":\\|:")[1];

                String message = messageSb.toString();
                if (message.contains(subString)) {
                    message = message.replaceFirst(subString, "");
                    StringBuilder subStringSb = new StringBuilder(subString);
                    subStringSb.reverse();
                    messageSb = new StringBuilder(message);
                    messageSb.append(subStringSb);
                    System.out.println(messageSb);
                } else {
                    System.out.println("error");
                }

            } else if (input.contains("ChangeAll")) {
                String substring = input.split(":\\|:")[1];
                String replacement = input.split(":\\|:")[2];

                String message = messageSb.toString().replaceAll(substring, replacement);
                messageSb = new StringBuilder(message);
                System.out.println(messageSb);
            }

            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", messageSb);
    }
}
