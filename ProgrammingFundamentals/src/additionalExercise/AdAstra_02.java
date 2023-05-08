package additionalExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();

        List<String> foodData = new ArrayList<>();
        String regex = "([|#])(?<name>[A-Za-z\\s]+)\\1(?<expiration>[0-9]{2}(\\/)[0-9]{2}\\4[0-9]{2})\\1(?<calories>[0-9]{1,5})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);

        int totalCaloriesSum = 0;
        while (matcher.find()) {
            String foodName = matcher.group("name");
            String expirationDate = matcher.group("expiration");
            int calories = Integer.parseInt(matcher.group("calories"));
            totalCaloriesSum += calories;

            foodData.add(String.join(", ","Item: " + foodName, "Best before: " + expirationDate, "Nutrition: " + calories));
        }

        int daysWithFood = totalCaloriesSum / 2000;

        System.out.printf("You have food to last you for: %d days!%n", daysWithFood);

        for (String food : foodData) {
            System.out.println(food);
        }
    }
}
