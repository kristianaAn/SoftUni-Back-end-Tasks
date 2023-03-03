package lection_01_WorkingWithAbstraction_lab.hotel;

public class PriceCalculator {

    public static double calculateHolidayPrice(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        double initialPrice = pricePerDay * numberOfDays;
        double seasonPrice = season.calculateCoeffPrice(initialPrice, season);
        return discount.calculateDiscountPrice(seasonPrice, discount);
    }
}
