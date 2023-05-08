package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> allTargets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String command = input.split(" ")[0];

            if (command.equals("Shoot")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int power = Integer.parseInt(input.split(" ")[2]);
                if (isValidIndex(allTargets, index)) {
                    int target = allTargets.get(index);
                    target -= power;
                    allTargets.set(index, target);
                    if (target <= 0) {
                        allTargets.remove(index);
                    }
                }
            } else if (command.equals("Add")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int value = Integer.parseInt(input.split(" ")[2]);

                if (isValidIndex(allTargets, index)) {
                    allTargets.add(index, value);
                } else {
                    System.out.println("Invalid placement!");
                }
            } else if (command.equals("Strike")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int radius = Integer.parseInt(input.split(" ")[2]);
                if (isRadiusValid(allTargets, radius, index)) {
                    int left = index - radius;
                    int right = index + radius;
                    for (int i = right; i >= left; i--) {
                        allTargets.remove(i);
                    }
                } else {
                    System.out.println("Strike missed!");
                    input = scanner.nextLine();
                    continue;
                }
            }


            input = scanner.nextLine();
        }
        for (int i = 0; i <= allTargets.size() - 1; i++) {
            if (i != allTargets.size() - 1) {
                System.out.print(allTargets.get(i) + "|");
            } else {
                System.out.print(allTargets.get(i));
            }
        }
    }

    public static boolean isValidIndex(List<Integer> numbers, int index) {
        return index >= 0 && index <= numbers.size() - 1;
    }

    public static boolean isRadiusValid(List<Integer> nums, int radius, int index) {
        int left = index - radius;
        int right = index + radius;
        boolean isInvalid = false;
        boolean isInvalid2 = false;

        if (left < 0) {
            isInvalid = true;
        }
        if (right > nums.size() - 1) {
            isInvalid2 = true;
        }
        if (!isInvalid && !isInvalid2) {
            return true;
        } else {
            return false;
        }
    }
}
