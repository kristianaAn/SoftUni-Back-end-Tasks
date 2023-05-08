package BasicSyntax_MoreExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersToReverse = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            int numToAdd = Integer.parseInt(scanner.nextLine());
            numbersToReverse.add(numToAdd);
        }

        Collections.sort(numbersToReverse);
        Collections.reverse(numbersToReverse);

        for (int num : numbersToReverse) {
            System.out.println(num);
        }
    }
}
