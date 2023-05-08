package Lection_04_DataTypes_Exercise;

import java.util.Scanner;

public class Snowballs_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nSnowballs = Integer.parseInt(scanner.nextLine());
        double snowBallValue = 0;
        double maxSnowBallValue = Double.MIN_VALUE;
        int maxSnowBallSnow = 0;
        int maxSnowBallTime = 0;
        int maxSnowBallQuality = 0;


        for (int i = 1; i <= nSnowballs; i++) {
            int snowBallSnow = Integer.parseInt(scanner.nextLine());
            int snowBallTime = Integer.parseInt(scanner.nextLine());
            int snowBallQuality = Integer.parseInt(scanner.nextLine());

            snowBallValue = (snowBallSnow * 1.0/ snowBallTime);
            snowBallValue = Math.pow(snowBallValue, snowBallQuality);

            if (snowBallValue > maxSnowBallValue) {
                maxSnowBallValue = snowBallValue;
                maxSnowBallSnow = snowBallSnow;
                maxSnowBallTime = snowBallTime;
                maxSnowBallQuality = snowBallQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", maxSnowBallSnow, maxSnowBallTime, maxSnowBallValue, maxSnowBallQuality);
    }
}
