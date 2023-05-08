package lection_16_TextProcessing_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReplaceRepeatingChars_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputText = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());

        for (int i = 1; i < inputText.size(); i++) {
            String currentSymbol = inputText.get(i);
            String previousSymbol = inputText.get(i - 1);

            if (currentSymbol.equals(previousSymbol)) {
                inputText.remove(i - 1);
                i--;
            }
        }
        for (int i = 0; i < inputText.size(); i++) {
            System.out.print(inputText.get(i));
        }
    }
}
