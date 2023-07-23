package com.example.springdataadvancedquerying.services;

import com.example.springdataadvancedquerying.entities.Ingredient;

import java.util.List;


public interface IngredientService {
    List<Ingredient> findAllByNameStartingWith(char letter);
    List<Ingredient> findAllByNameWithinOrderByPrice(List<String> stringList);

    void updateIngredientsName();

    void deleteIngredientByName(String name);
}
