package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneShop03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> initialPhones = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            if (input.contains("Add")) {
                String phoneToAdd = input.split(" - ")[1];
                if (initialPhones.contains(phoneToAdd)) {
                    input = scanner.nextLine();
                    continue;
                } else {
                    initialPhones.add(phoneToAdd);
                }
            } else if (input.contains("Remove")) {
                String phoneToRemove = input.split(" - ")[1];
                if (initialPhones.contains(phoneToRemove)) {
                    for (int i = 0; i <= initialPhones.size() - 1; i++) {
                        String currentPhone = initialPhones.get(i);
                        if (currentPhone.equals(phoneToRemove)) {
                            initialPhones.remove(initialPhones.get(i));
                        }
                    }
                } else {
                    input = scanner.nextLine();
                    continue;
                }

            } else if (input.contains("Bonus phone")) {
                String[] oldPhonePart = input.split(" ");
                String phonesOnly = oldPhonePart[3];
                String oldPhone = phonesOnly.split(":")[0];
                String newPhone = phonesOnly.split(":")[1];

                for (int i = 0; i <= initialPhones.size() - 1; i++) {
                    if (initialPhones.get(i).equals(oldPhone)) {
                        initialPhones.add(i + 1, newPhone);
                    }
                }
                input = scanner.nextLine();
                continue;

            } else if (input.contains("Last")) {
                String phoneToAdd = input.split(" - ")[1];
                for (int i = 0; i <= initialPhones.size() - 1; i++) {
                    String currentPhone = initialPhones.get(i);
                    if (currentPhone.equals(phoneToAdd)) {
                        initialPhones.add(currentPhone);
                        initialPhones.remove(i);
                    }
                }
                input = scanner.nextLine();
                continue;

            }

            input = scanner.nextLine();
        }
        for (int i = 0; i <= initialPhones.size() - 1; i++) {
            if (i == initialPhones.size() - 1) {
                System.out.print(initialPhones.get(i));
            } else {
                System.out.print(initialPhones.get(i) + ", ");
            }
        }
    }
}
