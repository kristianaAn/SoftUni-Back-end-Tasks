package lection_01_WorkingWithAbstraction_lab.hotel;

public enum Discount {
    None(0),
    SecondVisit(10),
    VIP(20);


    private int percentDiscount;

    Discount(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public double calculateDiscountPrice(double price, Discount discount) {
        return price - (price * (discount.percentDiscount * 1.00 / 100));
    }
}
