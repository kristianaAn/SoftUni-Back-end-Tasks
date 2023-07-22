package com.example.bookshopsystem.services;

import com.example.bookshopsystem.entities.Author;

import java.time.LocalDate;
import java.util.List;

public interface AuthorService {

    boolean isAuthorDataSeeded();

    void seedAuthor(List<Author> authors);

    Author getRandomAuthor();

    List<Author> getAuthorsByBookBeforeYear(LocalDate date);

    List<Author> getAuthorsByNumberOfBooksDesc();
}
