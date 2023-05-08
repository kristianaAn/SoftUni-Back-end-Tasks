package BasicSyntax_MoreExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseString_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.next().split("")).collect(Collectors.toList());

        Collections.reverse(input);

        for (String symbol: input) {
            System.out.print(symbol);
        }
    }
}
