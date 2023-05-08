package final_Exam_Preparation_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        int matchesCount = 0;
        List<String> mirrorMatches = new ArrayList<>();

        String regex = "([@|#])(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);

        while (matcher.find()) {
            matchesCount++;

            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            StringBuilder first = new StringBuilder(firstWord);
            String reversedFirstWord = first.reverse().toString();

            if (reversedFirstWord.equals(secondWord)) {
                String groupToAdd = firstWord + " <=> " + secondWord;
                mirrorMatches.add(groupToAdd);
            }
        }

        if (matchesCount == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", matchesCount);
        }

        if (mirrorMatches.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            for (int i = 0; i < mirrorMatches.size(); i++) {
                if (i != mirrorMatches.size() - 1) {
                    System.out.print(mirrorMatches.get(i) + ", ");
                } else {
                    System.out.print(mirrorMatches.get(i));
                }
            }
        }
    }
}
