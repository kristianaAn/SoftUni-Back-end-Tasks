package Lection_10_Lists_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> guestList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            List<String> wholeCommand = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String name = wholeCommand.get(0);

            if (wholeCommand.size() == 3) {
                if (guestList.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guestList.add(name);
                }
            } else if (wholeCommand.size() == 4) {
                if (guestList.contains(name)) {
                    guestList.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
          for (String guest : guestList) {
              System.out.println(guest + " ");
          }
    }
}
