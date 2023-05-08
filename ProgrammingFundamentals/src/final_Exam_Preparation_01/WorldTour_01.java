package final_Exam_Preparation_01;

import java.util.Scanner;

public class WorldTour_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String initialStops = scanner.nextLine();
        StringBuilder stops = new StringBuilder(initialStops);

        String input = scanner.nextLine();

        while (!input.equals("Travel")) {
            if (input.contains("Add Stop")) {
                int index = Integer.parseInt(input.split(":")[1]);
                String stopToAdd = input.split(":")[2];

                if (isIndexValid(index,stops)) {
                    stops.insert(index, stopToAdd);
                }

            } else if (input.contains("Remove Stop")) {
                int startIndex = Integer.parseInt(input.split(":")[1]);
                int endIndex = Integer.parseInt(input.split(":")[2]);

                if (isIndexValid(startIndex, stops) && isIndexValid(endIndex, stops)) {
                    stops.delete(startIndex, endIndex + 1);
                }

            } else if (input.contains("Switch")) {
                String oldString = input.split(":")[1];
                String newString = input.split(":")[2];

                if (initialStops.contains(oldString)) {
                    String stopToChange = stops.toString();
                    stopToChange = stopToChange.replace(oldString,newString);
                    stops = new StringBuilder(stopToChange);

                }
            }

            System.out.println(stops);

            input = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + stops);
    }

    public static boolean isIndexValid (int indexToCheck, StringBuilder text) {
        return indexToCheck >= 0 && indexToCheck <= text.length() - 1;
    }
}
