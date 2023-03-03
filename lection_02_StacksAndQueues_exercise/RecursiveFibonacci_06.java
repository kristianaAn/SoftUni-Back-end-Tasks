package lection_02_StacksAndQueues_exercise;

import java.util.Scanner;

public class RecursiveFibonacci_06 {
    public static long[] memory;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nFibonacciNumber = Integer.parseInt(scanner.nextLine());
        memory = new long[nFibonacciNumber + 1];
        long result = getFibonacci(nFibonacciNumber);
        System.out.println(result);

    }

    public static long getFibonacci(int n) {
        if (n < 2) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        return memory[n];
    }
}
