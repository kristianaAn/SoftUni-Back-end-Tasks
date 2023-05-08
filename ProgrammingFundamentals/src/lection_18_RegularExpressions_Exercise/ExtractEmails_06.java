package lection_18_RegularExpressions_Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(?<user>[A-Za-z0-9]+[.\\-_]?[A-Za-z0-9]+)@(?<word>[A-Za-z]+-?[A-Za-z]+)(\\.(?<word2>[A-Za-z]+-?[A-Za-z]+))+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String email = matcher.group();
            System.out.println(email);
        }
    }
}
