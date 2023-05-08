package final_Exam_Preparation_02;

import java.util.Scanner;

public class Activation_Keys_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rawActivationKey = scanner.nextLine();
        StringBuilder activationKeySb = new StringBuilder(rawActivationKey);

        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            if (input.contains("Contains")) {
                String substring = input.split(">>>")[1];

                if (activationKeySb.toString().contains(substring)) {
                    System.out.printf("%s contains %s%n", activationKeySb, substring);
                } else {
                    System.out.println("Substring not found!");
                }

            } else if (input.contains("Flip")) {
                String flipCommand = input.split(">>>")[1];
                int startIndex = Integer.parseInt(input.split(">>>")[2]);
                int endIndex = Integer.parseInt(input.split(">>>")[3]);

                if (flipCommand.equals("Upper")) {
                    activationKeySb.replace(startIndex, endIndex, activationKeySb.substring(startIndex, endIndex).toUpperCase());
                    System.out.println(activationKeySb);

                } else if (flipCommand.equals("Lower")) {
                    activationKeySb.replace(startIndex,endIndex,activationKeySb.substring(startIndex,endIndex).toLowerCase());
                    System.out.println(activationKeySb);

                }

            } else if (input.contains("Slice")) {
                int startIndex = Integer.parseInt(input.split(">>>")[1]);
                int endIndex = Integer.parseInt(input.split(">>>")[2]);

                activationKeySb.delete(startIndex,endIndex);
                System.out.println(activationKeySb);

            }

            input = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s", activationKeySb);
    }
}
