package Lection_10_Lists_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        //Delete {element}
        //Insert {element} {position}
        String input = scanner.nextLine();
        String commnd = "";

        while (!input.equals("end")) {
            commnd = input.split(" ")[0];

            switch (commnd) {
                case "Delete":
                    int numberToRemove = Integer.parseInt(input.split(" ")[1]);
                    for (int i = 0; i < nums.size(); i++) {
                        int numCheck = nums.get(i);
                        if (numCheck == numberToRemove) {
                            nums.remove(nums.get(i));
                        }
                    }
                    break;
                case "Insert":
                    int numToInsert = Integer.parseInt(input.split(" ")[1]);
                    int index = Integer.parseInt(input.split(" ")[2]);
                    if (index <= nums.size() && index >= 0) {
                        nums.add(index,numToInsert);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
