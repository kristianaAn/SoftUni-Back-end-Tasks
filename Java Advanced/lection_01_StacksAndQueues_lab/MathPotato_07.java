package lection_01_StacksAndQueues_lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputPlayers = scanner.nextLine().split("\\s+"); //Sam John Sara
        int tossCount = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> playersQueue = new ArrayDeque<>();

        for (int i = 0; i < inputPlayers.length; i++) {
            playersQueue.offer(inputPlayers[i]);
        }

        int cycleCount = 1;
        while (playersQueue.size() > 1) {

            for (int i = 1; i < tossCount; i++) {
                String currentChild = playersQueue.poll();
                playersQueue.offer(currentChild);
            }

            if (isPrime(cycleCount)) {
                //prime + print name
                System.out.println("Prime " + playersQueue.peek());
            } else {
                //removed + print name
                System.out.println("Removed " + playersQueue.poll());
            }

            cycleCount++;
        }

        System.out.println("Last is " + playersQueue.peek());
    }

    public static boolean isPrime (int cycleCount) { //е просто число
        if (cycleCount <= 1) {
            return false;
        } else if ((cycleCount % 2 == 0 || cycleCount % 3 == 0) && (cycleCount != 2 && cycleCount != 3)) {
            return false;
        } else {
            return true;
        }
    }
}
