package com.example.springdataadvancedquerying.services;

import com.example.springdataadvancedquerying.entities.Ingredient;
import com.example.springdataadvancedquerying.entities.Shampoo;
import com.example.springdataadvancedquerying.entities.Size;
import com.example.springdataadvancedquerying.repositories.ShampoosRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampoosRepository shampoosRepository;

    public ShampooServiceImpl(ShampoosRepository shampoosRepository) {
        this.shampoosRepository = shampoosRepository;
    }

    @Override
    public List<Shampoo> findByBrand(String brand) {
        return shampoosRepository.findByBrand(brand);
    }

    @Override
    public List<Shampoo> findByBrandAndSize(String brand, Size size) {
        return shampoosRepository.findByBrandAndSize(brand, size);
    }

    @Override
    public List<Shampoo> findBySizeOrderById(Size size) {
        return shampoosRepository.findBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> findAllBySizeOrLabelId(Size size, Long id) {
        return shampoosRepository.findAllBySizeOrLabelId(size, id);
    }

    @Override
    public List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price) {
        return shampoosRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int countAllByPriceLessThan(BigDecimal price) {
        return shampoosRepository.countAllByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> findShampoosByIngredients(List<String> ingredientList) {
        return shampoosRepository.findShampoosByIngredientsNameIn(ingredientList);
    }

    @Override
    public List<Shampoo> findShampooByIngredientsQuery(List<String> ingredientList) {
        return shampoosRepository.findShampooByIngredientsQuery(ingredientList);
    }

    @Override
    public List<Shampoo> countShampoosWithIngredientsLessThan(int number) {
        return shampoosRepository.countAllByIngredientsIsLessThan(number);
    }
}
