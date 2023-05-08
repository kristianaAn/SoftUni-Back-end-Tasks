package lection_18_RegularExpressions_Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[, ]+");

        for (int i = 0; i < input.length; i++) {
            String currentDemon = input[i];
            int health = demonHealth(currentDemon);
            double damage = demonDamage(currentDemon);

            System.out.printf("%s - %d health, %.2f damage%n", currentDemon, health, damage);
        }
    }
    public static int demonHealth (String demon) {
        int healthAmount = 0;
        for (int i = 0; i < demon.length(); i++) {
            char symbol = demon.charAt(i);
            //'+', '-', '*', '/'
            if (!Character.isDigit(symbol) && symbol != '+' && symbol != '-' && symbol != '*' && symbol != '/' && symbol != '.') {
                healthAmount += symbol;
            }
        }
        return healthAmount;
    }

    public static double demonDamage (String demonName) {
        double damageAmount = 0;
        String regex = "(?<number>[\\+-]?[0-9]+[.]?[0-9]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(demonName);

        while (matcher.find()) {
            double number = Double.parseDouble(matcher.group("number"));
            damageAmount += number;
        }

        for (int i = 0; i <demonName.length() ; i++) {
            if (demonName.charAt(i) == '*') {
                damageAmount = damageAmount * 2;
            } else if (demonName.charAt(i) == '/') {
                damageAmount = damageAmount / 2;
            }
        }
        return damageAmount;
    }

}
