package lection_18_RegularExpressions_Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> racersNames = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        Map<String, Integer> racersNamesAndDistances = new LinkedHashMap<>();

        String regexLetters = "[A-Za-z]+";
        Pattern patternLetters = Pattern.compile(regexLetters);
        String regexDigits = "[0-9]";
        Pattern patternDigits = Pattern.compile(regexDigits);

        while (!input.equals("end of race")) {
            StringBuilder name = new StringBuilder();
            int distance = 0;

            Matcher matcherDigits = patternDigits.matcher(input);
            Matcher matcherLetters = patternLetters.matcher(input);

            while (matcherLetters.find()) {
               name.append(matcherLetters.group());
            }

            while (matcherDigits.find()) {
                int num = Integer.parseInt(matcherDigits.group());
                distance += num;
            }

            String racersName = name.toString();
            if (racersNames.contains(racersName)) {
                if (!racersNamesAndDistances.containsKey(racersName)) {
                    racersNamesAndDistances.put(racersName, distance);
                } else if (racersNamesAndDistances.containsKey(racersName)){
                    racersNamesAndDistances.put(racersName, racersNamesAndDistances.get(racersName) + distance);
                }
            }


            input = scanner.nextLine();
        }

        List<String> finalists = racersNamesAndDistances.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .map(entry -> entry.getKey())
                        .collect(Collectors.toList());

        System.out.printf("1st place: %s%n", finalists.get(0));
        System.out.printf("2nd place: %s%n", finalists.get(1));
        System.out.printf("3rd place: %s", finalists.get(2));

    }
}
