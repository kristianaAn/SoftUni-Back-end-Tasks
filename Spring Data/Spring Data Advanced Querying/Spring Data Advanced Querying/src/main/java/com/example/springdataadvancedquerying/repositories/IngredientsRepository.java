package com.example.springdataadvancedquerying.repositories;

import com.example.springdataadvancedquerying.entities.Ingredient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(char letter);
    List<Ingredient> findAllByNameInOrderByPrice(List<String> stringList);

    @Modifying
    @Transactional
    @Query("UPDATE Ingredient AS i SET i.name = CONCAT(i.name,'UPDATED')")
    void updateIngredientsName();

    @Transactional
    void deleteIngredientByName(String name);
}
