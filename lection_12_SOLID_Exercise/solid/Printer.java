package lection_12_SOLID_Exercise.solid;

import lection_12_SOLID_Exercise.solid.calculators.Calculator;

import java.util.List;

public class Printer {
    private Calculator calculator;

    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    public Printer(Calculator calculator) {
        this.calculator = calculator;
    }

    public void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", calculator.calculateTotal(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", calculator.calculateAverage(products));
    }
}
