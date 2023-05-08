package Lection_06_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //2 1 1 2 3 3 2 2 2 1
        //0 1 2 3 4 5 6 7 8 9
        int maxSequence = 0;
        int sequenceCount = 1;
        int startIndex = 0;
        int mostLeftIndex = 0;
        for (int i = 1; i < numsArray.length; i++) {
            if (numsArray[i] == numsArray[i - 1]) {
                sequenceCount++;
            } else {
                sequenceCount = 1;
                startIndex = i;
            }

            if (sequenceCount > maxSequence) {
                maxSequence = sequenceCount;
                mostLeftIndex = startIndex;
            }
        }
        for (int i = mostLeftIndex; i < mostLeftIndex + maxSequence; i++) {
            System.out.print(numsArray[i] + " ");
        }
    }
}
