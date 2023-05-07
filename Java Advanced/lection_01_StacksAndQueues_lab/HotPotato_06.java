package lection_01_StacksAndQueues_lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputPlayers = scanner.nextLine().split("\\s+"); //Sam John Sara
        int tossCount = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> playersQueue = new ArrayDeque<>();

        for (int i = 0; i < inputPlayers.length; i++) {
            playersQueue.offer(inputPlayers[i]);
        }

        while (playersQueue.size() > 1) {
            for (int i = 1; i < tossCount; i++) {
                String currentChild = playersQueue.poll();
                playersQueue.offer(currentChild);
            }
            String childToRemove = playersQueue.poll();
            System.out.println("Removed " + childToRemove);
        }

        System.out.println("Last is " + playersQueue.peek());

    }
}
