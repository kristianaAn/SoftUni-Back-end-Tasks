package com.example.bookshopsystem.services;

import com.example.bookshopsystem.entities.Category;
import com.example.bookshopsystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isCategoryDataSeeded() {
        return this.categoryRepository.count() > 0;
    }

    @Override
    public void seedCategory(List<Category> categories) {
        this.categoryRepository.saveAll(categories);
    }

    @Override
    public List<Category> getRandomCategories() {
        long count = this.categoryRepository.count();

        if (count == 0) {
            throw new IllegalArgumentException();
        }

        long randomLong = new Random().nextLong(1L, count) + 1L;

        return this.categoryRepository.findAllById(Collections.singleton(randomLong)).stream().toList();
    }
}
