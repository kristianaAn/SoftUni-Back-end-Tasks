package final_Exam_Preparation_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputDestinations = scanner.nextLine();

        String regex = "(=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputDestinations);

        int travelPoints = 0;

        List<String> destinations = new ArrayList<>();
        while (matcher.find()) {
            String validDestination = matcher.group("destination");
            travelPoints += validDestination.length();
            destinations.add(validDestination);
        }

        System.out.print("Destinations: ");
        System.out.print(String.join(", ", destinations));
        System.out.println();
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
