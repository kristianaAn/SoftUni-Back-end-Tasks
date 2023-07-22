package com.example.bookshopsystem.services;

import com.example.bookshopsystem.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    boolean isCategoryDataSeeded();

    void seedCategory(List<Category> categories);

    List<Category> getRandomCategories();
}
