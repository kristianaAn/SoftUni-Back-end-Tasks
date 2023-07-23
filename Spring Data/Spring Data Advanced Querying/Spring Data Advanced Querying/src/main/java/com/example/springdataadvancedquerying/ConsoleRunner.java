package com.example.springdataadvancedquerying;

import com.example.springdataadvancedquerying.entities.Ingredient;
import com.example.springdataadvancedquerying.entities.Shampoo;
import com.example.springdataadvancedquerying.services.IngredientService;
import com.example.springdataadvancedquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Test task 1:
//        List<Shampoo> byBrand = shampooService.findByBrand("Swiss Green Apple & Nettle");
//        byBrand.forEach(shampoo -> System.out.println(shampoo.toString()));

        // Test task 2:
//        List<Shampoo> byBrandAndSize = shampooService.findByBrandAndSize("Swiss Green Apple & Nettle", Size.SMALL);
//        byBrandAndSize.forEach(System.out::println);

//        1. Select Shampoos by Size:
//        List<Shampoo> allBySize = shampooService.findBySizeOrderById(Size.MEDIUM);
//        allBySize.forEach(System.out::println);

//        2. Select Shampoos by Size or Label
//        List<Shampoo> allBySizeOrLabel = shampooService.findAllBySizeOrLabelId(Size.MEDIUM, 10L);
//        allBySizeOrLabel
//                .stream()
//                .sorted((l, r) -> l.getPrice().compareTo(r.getPrice()))
//                .forEach(System.out::println);

//        3. Select Shampoos by Price
//        List<Shampoo> allByPriceGreaterThanOrderByPriceDesc = shampooService
//                .findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal.valueOf(5));
//        allByPriceGreaterThanOrderByPriceDesc.forEach(System.out::println);

//        4. Select Ingredients by Name
//        List<Ingredient> ingredientsStartingWith = ingredientService.findAllByNameStartingWith('M');
//        ingredientsStartingWith.forEach(System.out::println);

//        5. Select Ingredients by Names
//        List<Ingredient> allByNameWithinOrderByPrice = ingredientService
//                .findAllByNameWithinOrderByPrice(List.of("Lavender", "Herbs", "Apple"));
//
//        allByNameWithinOrderByPrice.forEach(System.out::println);

//        6. Count Shampoos by Price
//        System.out.println(shampooService.countAllByPriceLessThan(BigDecimal.valueOf(8.50)));

//        7. Select Shampoos by Ingredients (1st solution)
//        List<Shampoo> shampoosByIngredients = shampooService.findShampoosByIngredients(List.of("Berry", "Mineral-Collagen"));
//        shampoosByIngredients.forEach(System.out::println);

//        7. Select Shampoos by Ingredients (2nd solution)
//        List<Shampoo> shampoos = shampooService.findShampooByIngredientsQuery(List.of("Berry", "Mineral-Collagen"));
//        shampoos.forEach(System.out::println);

//        8. Select Shampoos by Ingredients Count
//        List<Shampoo> shampoos = shampooService.countShampoosWithIngredientsLessThan(2);
//        shampoos.forEach(shampoo -> System.out.println(shampoo.onlyBrandToString()));

//        9. Delete Ingredients by Name
//          ingredientService.deleteIngredientByName("LavenderUPDATED");

//        10. Update Ingredients by Price
//        ingredientService.updateIngredientsName();
    }
}
