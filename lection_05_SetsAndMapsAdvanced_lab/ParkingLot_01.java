package lection_05_SetsAndMapsAdvanced_lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> carsIn = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String direction = input.split(", ")[0];
            String registrationNumber = input.split(", ")[1];

            if (direction.equals("IN")) {
               carsIn.add(registrationNumber);
            } else if (direction.equals("OUT")) {
               carsIn.remove(registrationNumber);
            }
            input = scanner.nextLine();
        }

        if (carsIn.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String number : carsIn) {
                System.out.println(number);
            }
        }
    }
}
