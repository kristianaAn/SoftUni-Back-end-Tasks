package Lection_10_Lists_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int capacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            if (input.contains("Add")) {
                int wagonToAdd = Integer.parseInt(input.split(" ")[1]);
                wagons.add(wagonToAdd);
            } else {
                int passengersToAdd = Integer.parseInt(input);

                for (int i = 0; i < wagons.size(); i++) {
                    int currentNum = wagons.get(i);
                    int sum = currentNum + passengersToAdd;
                    if (sum <= capacity) {
                        wagons.set(i, sum);
                        break;
                    }
                }
            }

            input = scanner.nextLine();
        }
        for (int num : wagons) {
            System.out.print(num + " ");
        }
    }
}
