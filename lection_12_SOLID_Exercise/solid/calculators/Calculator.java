package lection_12_SOLID_Exercise.solid.calculators;

import lection_12_SOLID_Exercise.solid.Product;

import java.util.List;

public interface Calculator {
    double calculateTotal(List<Product> products);

    double calculateAverage(List<Product> products);
}
