package Lection_09_Lists_Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> inputNums = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 1; i < inputNums.size(); i++) {
            double sumCurrNums = 0;
            if (inputNums.get(i).equals(inputNums.get(i - 1))) {
                sumCurrNums = inputNums.get(i) + inputNums.get(i - 1);
                inputNums.set(i, sumCurrNums);
                inputNums.remove(inputNums.get(i - 1));
                i = 0;
            }
        }
        String pattern = "0.#";
        DecimalFormat df = new DecimalFormat("0.#");
        for (double currNum : inputNums) {
            System.out.print(df.format(currNum) + " ");
        }
    }
}
