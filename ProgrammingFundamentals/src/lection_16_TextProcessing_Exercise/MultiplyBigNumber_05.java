package lection_16_TextProcessing_Exercise;

import java.util.Scanner;

public class MultiplyBigNumber_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstNumber = scanner.nextLine().split("");
        int secondNumber = Integer.parseInt(scanner.nextLine());

        boolean isZero = false;
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int totalResult = 0;

        for (int i = firstNumber.length - 1; i >= 0; i--) {
            int num = Integer.parseInt(firstNumber[i]);

            if (secondNumber == 0) {
                isZero = true;
                break;
            }

            result += num * secondNumber;

            totalResult += result;
            if (result > 9) {
                int secondDigit = result % 10;
                int firstDigit = result / 10;

                sb.append(secondDigit);

                result = firstDigit;
            } else {
                sb.append(result);
                result = 0;
            }

            if (i == 0 && result > 0) {
                sb.append(result);
            }

            if (totalResult == 0) {
                isZero = true;
            }

        }
        if (isZero) {
            System.out.println("0");
        } else {
            StringBuilder output = new StringBuilder();
            boolean trailing = true;
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (Integer.parseInt(sb.substring(i, i + 1)) == 0 && trailing) {

                } else {
                    trailing = false;
                    output.append(sb.charAt(i));
                }
            }
            System.out.println(output.toString());
        }
    }
}
