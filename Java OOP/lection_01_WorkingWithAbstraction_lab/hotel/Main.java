package lection_01_WorkingWithAbstraction_lab.hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] holidayData = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(holidayData[0]);
        int numberOfDays = Integer.parseInt(holidayData[1]);
        Season season = Season.valueOf(holidayData[2]);
        Discount discount = Discount.valueOf(holidayData[3]);

        System.out.printf("%.2f", PriceCalculator.calculateHolidayPrice(pricePerDay, numberOfDays, season, discount));
    }
}
