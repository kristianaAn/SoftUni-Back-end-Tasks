package com.example.products_shop.services;

import java.io.IOException;

public interface SeedService {
    void seedCategories() throws IOException;
    void seedProducts() throws IOException;
    void seedUsers() throws IOException;
    default void seedAll() throws IOException {
        seedUsers();
        seedProducts();
        seedCategories();
    };
}
