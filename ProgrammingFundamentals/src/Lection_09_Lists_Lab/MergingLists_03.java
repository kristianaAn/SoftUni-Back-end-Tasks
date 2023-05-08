package Lection_09_Lists_Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numsList2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        int position = 0;
        for (int i = 0; i < Math.min(numsList1.size(), numsList2.size()); i++) {
            resultList.add(position, numsList1.get(i));
            position++;
            resultList.add(position, numsList2.get(i));
            position++;
        }

        if (numsList1.size() > numsList2.size()) {
            resultList.addAll(remainingNums(numsList1, numsList2));
        } else if (numsList2.size() > numsList1.size()) {
            resultList.addAll(remainingNums(numsList2, numsList1));
        }

        for (int num : resultList) {
            System.out.print(num + " ");
        }

    }
    public static List<Integer> remainingNums (List<Integer> longerList, List<Integer> shorterList) {
        List<Integer> resultingList = new ArrayList<>();
        for (int i = shorterList.size(); i < longerList.size(); i++) {
            resultingList.add(longerList.get(i));
        }
        return resultingList;
    }
}
