package additionalExercise;

import java.util.Scanner;

public class PasswordReset_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String initialPass = scanner.nextLine();
        String command = scanner.nextLine();



        while (!command.equals("Done")) {
            if (command.contains("TakeOdd")) {

                StringBuilder newPasswordSb = new StringBuilder();

                for (int i = 1; i < initialPass.length(); i += 2) {
                    char symbolToGet = initialPass.charAt(i);
                    newPasswordSb.append(symbolToGet);
                }

                initialPass = newPasswordSb.toString();
                System.out.println(initialPass);

            } else if (command.contains("Cut")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int length = index + Integer.parseInt(command.split(" ")[2]);

                initialPass = new StringBuilder(initialPass).delete(index, length).toString();

                System.out.println(initialPass);

            } else if (command.contains("Substitute")) {
                String substringToFind = command.split(" ")[1];
                String substitute = command.split(" ")[2];

                if (!initialPass.contains(substringToFind)) {
                    System.out.println("Nothing to replace!");
                } else {
                    initialPass = initialPass.replace(substringToFind, substitute);
                    System.out.println(initialPass);
                }
            }

            command = scanner.nextLine();
        }

        System.out.printf("Your password is: %s", initialPass);
    }
}
