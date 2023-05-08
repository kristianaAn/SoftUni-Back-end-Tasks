package additionalExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();

        int coolThreshold = 1;
        for (int i = 0; i < inputText.length(); i++) {
            char currentSymbol = inputText.charAt(i);

            if (Character.isDigit(currentSymbol)) {
                int digit = Character.getNumericValue(currentSymbol);
                coolThreshold *= digit;
            }
        }

        List<String> coolEmojis = new ArrayList<>();
        int allMatchesCount = 0;
        String regex = "(?<wholeEmoji>([**]{2}|[\\:\\:]{2})(?<emoji>[A-Z]{1}[a-z]{2,})\\2)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);

        while (matcher.find()) {
            String emoji = matcher.group("emoji");
            String wholeEmoji = matcher.group("wholeEmoji");
            allMatchesCount++;

            if (coolNessValue(emoji) >= coolThreshold) {
                coolEmojis.add(wholeEmoji);
            }

        }

        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", allMatchesCount);
        for (String emoji : coolEmojis) {
            System.out.println(emoji);
        }

    }
    public static int coolNessValue (String emoji) {
        int coolNess = 0;
        for (int i = 0; i < emoji.length(); i++) {
            char currentSymbol = emoji.charAt(i);
            coolNess += (int) currentSymbol;
        }
        return coolNess;
    }
}
