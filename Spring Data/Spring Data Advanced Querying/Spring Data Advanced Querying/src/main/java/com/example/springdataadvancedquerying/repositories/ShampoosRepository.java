package com.example.springdataadvancedquerying.repositories;

import com.example.springdataadvancedquerying.entities.Ingredient;
import com.example.springdataadvancedquerying.entities.Shampoo;
import com.example.springdataadvancedquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampoosRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, Size size);

    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelId(Size size, Long id);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceLessThan(BigDecimal price);

    List<Shampoo> findShampoosByIngredientsNameIn(List<String> ingredientList);

    @Query("SELECT s " +
            "FROM Shampoo AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE i.name IN :ingredientsList")
    List<Shampoo> findShampooByIngredientsQuery(List<String> ingredientsList);

    @Query("SELECT s, COUNT(i) " +
            "FROM Shampoo AS s " +
            "JOIN s.ingredients AS i " +
            "GROUP BY s.id " +
            "HAVING COUNT(i) < :number")
    List<Shampoo> countAllByIngredientsIsLessThan(int number);
}
