package Lection_11_Objects_and_Classes;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger numberOne = new BigInteger(scanner.nextLine());
        BigInteger numberTwo = new BigInteger(scanner.nextLine());

        BigInteger result = numberOne.add(numberTwo);

        System.out.println(result);
    }
}
