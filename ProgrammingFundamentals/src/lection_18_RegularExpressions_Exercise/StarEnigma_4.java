package lection_18_RegularExpressions_Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "[^@\\-!:>]*?@(?<planetName>[A-Za-z]+)[^@\\-!:>]*?:(?<population>\\d+)[^@\\-!:>]*?!" +
                "(?<attack>[A,D])![^@\\-!:>]*?->(?<soldierCount>\\d+)[^@\\-!:>]*?\\b";
        Pattern pattern = Pattern.compile(regex);
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String encryptedMessage = scanner.nextLine();
            String decryptedMessage = decryptedMessage(encryptedMessage);

            Matcher matcher = pattern.matcher(decryptedMessage);

            while (matcher.find()) {
                String planetName = matcher.group("planetName");
                int population = Integer.parseInt(matcher.group("population"));
                String attack = matcher.group("attack");
                int soldierCount = Integer.parseInt(matcher.group("soldierCount"));

                if (attack.equals("A")) {
                    attackedPlanets.add(planetName);
                } else if (attack.equals("D")) {
                    destroyedPlanets.add(planetName);
                }
            }
        }
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);
        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        attackedPlanets.forEach(entry -> System.out.printf("-> %s%n", entry));
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        destroyedPlanets.forEach(entry -> System.out.printf("-> %s%n", entry));
    }

    public static String decryptedMessage (String initialMessage) {
        String newMessage = "";
        int number = countOfSpecialLetters(initialMessage);
        for (char i = 0; i < initialMessage.length(); i++) {
            char currentSymbol = initialMessage.charAt(i);
            newMessage = newMessage + (char) (currentSymbol - number);
        }
        return newMessage;
    }

    public static int countOfSpecialLetters(String encryptedMessage) {
        int count = 0;
        for (char symbol : encryptedMessage.toCharArray()) {
            switch (symbol) {
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                case 's':
                case 't':
                case 'a':
                case 'r':
                    count++;
                    break;
            }
        }
        return count;
    }
}
