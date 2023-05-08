package DataTypes_MoreExercise;

import java.math.BigInteger;
import java.util.Scanner;

public class FromLeftToTheRight_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= n; i++) {
            BigInteger firstNum = new BigInteger(scanner.next());
            BigInteger secondNum = new BigInteger(scanner.next());


            if (firstNum.compareTo(secondNum) > 0) {
                printSumOfBiggerNumber(firstNum);
            } else if (firstNum.compareTo(secondNum) < 0) {
                printSumOfBiggerNumber(secondNum);
            } else if (firstNum.compareTo(secondNum) == 0) {
                printSumOfBiggerNumber(secondNum);
            }
        }
    }
    public static void printSumOfBiggerNumber (BigInteger number) {
        BigInteger one = new BigInteger("1");
        BigInteger ten = new BigInteger("10");
        BigInteger sum = new BigInteger("0");
        while (number.compareTo(one) == 0 || number.compareTo(one) == 1) {
            sum = sum.add(number.remainder(ten));
            number = number.divide(ten);
        }
        System.out.println(sum);
    }
}
