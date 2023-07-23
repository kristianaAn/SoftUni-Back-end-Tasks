package com.example.springdataadvancedquerying.services;

import com.example.springdataadvancedquerying.entities.Shampoo;
import com.example.springdataadvancedquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> findByBrand(String brand);
    List<Shampoo> findByBrandAndSize(String brand, Size size);

    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelId(Size size, Long id);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceLessThan(BigDecimal price);

    List<Shampoo> findShampoosByIngredients(List<String> ingredientList);
    List<Shampoo> findShampooByIngredientsQuery(List<String> ingredientList);

    List<Shampoo> countShampoosWithIngredientsLessThan(int number);
}
