package Lection_11_Objects_and_Classes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputWords = Arrays.stream(scanner.nextLine().split(" 0")).collect(Collectors.toList());

        Random rndWords = new Random();

        while (inputWords.size() > 0) {
            int randomIndex = rndWords.nextInt(inputWords.size());
            System.out.println(inputWords.get(randomIndex));
            inputWords.remove(randomIndex);
        }

    }
}
