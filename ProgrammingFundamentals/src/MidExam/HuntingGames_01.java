package MidExam;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class HuntingGames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nDaysOfAdventure = Integer.parseInt(scanner.nextLine());
        int numOfPlayers = Integer.parseInt(scanner.nextLine());
        float groupEnergy = Float.parseFloat(scanner.nextLine());
        float waterPerDayPerPerson = Float.parseFloat(scanner.nextLine());
        float foodPerDayPerPerson = Float.parseFloat(scanner.nextLine());

        double totalWater = waterPerDayPerPerson * numOfPlayers * nDaysOfAdventure;
        double totalFood = foodPerDayPerPerson * numOfPlayers * nDaysOfAdventure;


        for (int i = 1; i <= nDaysOfAdventure; i++) {
            float energyLossPerDay = Float.parseFloat(scanner.nextLine());

            groupEnergy = groupEnergy - energyLossPerDay;
            if (groupEnergy <= 0) {
                break;
            }

            if (i % 2 == 0) {
                groupEnergy = (groupEnergy + (groupEnergy * 0.05f)) * 1.00f;
                totalWater = (totalWater - (totalWater * 0.30f)) * 1.00f;
            }

            if (i % 3 == 0) {
                totalFood = totalFood - (totalFood / numOfPlayers);
                groupEnergy = groupEnergy + (groupEnergy * 0.10f);
            }
        }
        if (groupEnergy > 0) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", totalFood, totalWater);
        }
    }
}
