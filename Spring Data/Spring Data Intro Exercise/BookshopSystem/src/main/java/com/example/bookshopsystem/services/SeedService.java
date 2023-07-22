package com.example.bookshopsystem.services;

import org.springframework.stereotype.Service;

import java.io.IOException;

public interface SeedService {

    void seedBook() throws IOException;
    void seedAuthor() throws IOException;
    void seedCategory() throws IOException;

    default void seedAll() throws IOException {
        seedAuthor();
        seedCategory();
        seedBook();
    }
}
