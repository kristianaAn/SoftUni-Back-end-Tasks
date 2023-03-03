package lection_02_StacksAndQueues_exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int nElementsToEnqueue = Integer.parseInt(input.split("\\s+")[0]); //offer
        int sElementsToDequeue = Integer.parseInt(input.split("\\s+")[1]); //poll
        int xElementIsPresent = Integer.parseInt(input.split("\\s+")[2]);  //contains

        ArrayDeque<Integer> numsQueue = new ArrayDeque<>();

        for (int i = 0; i < nElementsToEnqueue; i++) {
            int numToAdd = scanner.nextInt();
            numsQueue.offer(numToAdd);
        }

        for (int i = 0; i < sElementsToDequeue; i++) {
            numsQueue.poll();
        }

        if (numsQueue.contains(xElementIsPresent)) {
            System.out.println(true);
        } else if (numsQueue.isEmpty()) {
            System.out.println("0");
        } else {
            printSmallestNumInQueue(numsQueue);
        }
    }
    public static void printSmallestNumInQueue (ArrayDeque<Integer> numsQueue) {
        int minNum = Integer.MAX_VALUE;
        for (Integer integer : numsQueue) {
            if (integer < minNum) {
                minNum = integer;
            }
        }
        System.out.println(minNum);
    }
}
