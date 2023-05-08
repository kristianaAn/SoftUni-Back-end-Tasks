package MidExamPreparation;

import java.util.Scanner;

public class MuOnline_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rooms = scanner.nextLine().split("\\|");
        int health = 100;
        int bitcoins = 0;
        //start health = 100
        //initial bitcoins = 0;
        String currentRoom = "";
        for (int i = 0; i <= rooms.length - 1; i++) {
            currentRoom = rooms[i];


            String command = currentRoom.split(" ")[0];
            if (command.equals("potion")) {
               int amount = Integer.parseInt(currentRoom.split(" ")[1]);
               int currentHealth = health;
               health += amount;
               if (health > 100) {
                   health = 100;
                   System.out.printf("You healed for %d hp.%n", health - currentHealth);
               } else {
                   System.out.printf("You healed for %d hp.%n", amount);
               }
                System.out.printf("Current health: %d hp.%n", health);
            } else if (command.equals("chest")) {
                int bitcoinsCount = Integer.parseInt(currentRoom.split(" ")[1]);
                bitcoins += bitcoinsCount;
                System.out.printf("You found %d bitcoins.%n", bitcoinsCount);
            } else {
                int attackPower = Integer.parseInt(currentRoom.split(" ")[1]);
                health -= attackPower;
                if (health > 0) {
                    System.out.printf("You slayed %s.%n", command);
                } else {
                    System.out.printf("You died! Killed by %s.%n", command);
                    System.out.printf("Best room: %d%n", i + 1);
                    break;
                }
            }
        }
          if (health > 0) {
              System.out.println("You've made it!");
              System.out.printf("Bitcoins: %d%n", bitcoins);
              System.out.printf("Health: %d", health);
          }

    }
}
