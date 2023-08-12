package com.example.products_shop.repositories;

import com.example.products_shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from `product-shop`.products order by RAND() LIMIT 1", nativeQuery = true)
    Optional<Product> getRandomEntity();

    List<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal low, BigDecimal high);
}
