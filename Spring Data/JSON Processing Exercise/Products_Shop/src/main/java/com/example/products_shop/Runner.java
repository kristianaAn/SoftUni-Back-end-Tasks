package com.example.products_shop;

import com.example.products_shop.services.ProductService;
import com.example.products_shop.services.SeedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Runner implements CommandLineRunner {
    private final SeedService seedService;
    private final ProductService productService;

    public Runner(SeedService seedService, ProductService productService) {
        this.seedService = seedService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
       this.seedService.seedAll();
       this.productService.findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
    }
}
