package com.example.springdataadvancedquerying.services;

import com.example.springdataadvancedquerying.entities.Ingredient;
import com.example.springdataadvancedquerying.repositories.IngredientsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientsRepository ingredientsRepository;

    public IngredientServiceImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public List<Ingredient> findAllByNameStartingWith(char letter) {
        return ingredientsRepository.findAllByNameStartingWith(letter);
    }

    @Override
    public List<Ingredient> findAllByNameWithinOrderByPrice(List<String> stringList) {
        return ingredientsRepository.findAllByNameInOrderByPrice(stringList);
    }

    @Override
    public void updateIngredientsName() {
        ingredientsRepository.updateIngredientsName();
    }

    @Override
    public void deleteIngredientByName(String name) {
        ingredientsRepository.deleteIngredientByName(name);
    }
}
