package lection_01_WorkingWithAbstraction_lab.hotel;

public enum Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);


    private int coefficient;

    Season(int coefficient) {
        this.coefficient = coefficient;
    }

    public double calculateCoeffPrice (double price, Season season) {
        return price * season.coefficient;
    }
}
