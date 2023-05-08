package finalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String regex = "([|])(?<bossName>[A-Z]{4,})\\1:([#])(?<title>[A-Za-z]+[\\s]{1}[A-Za-z]+)\\3";
        Pattern pattern = Pattern.compile(regex);


        for (int i = 1; i <= n; i++) {
           String bossInput = scanner.nextLine();
            Matcher matcher = pattern.matcher(bossInput);
            boolean isValid = false;

            while (matcher.find()) {
                String bossName = matcher.group("bossName");
                String title = matcher.group("title");
                isValid = true;

                System.out.printf("%s, The %s%n", bossName, title);
                System.out.printf(">> Strength: %d%n", bossName.length());
                System.out.printf(">> Armor: %d%n", title.length());
            }

            if (!isValid) {
                System.out.println("Access denied!");
            }
        }
    }
}
