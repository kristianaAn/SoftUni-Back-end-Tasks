package com.example.bookshopsystem.services;

import com.example.bookshopsystem.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    boolean isBookDataSeeded();

    void seedBook(List<Book> books);

    List<Book> getBooksAfterYear(LocalDate date);
    List<Book> getBooksBeforeYear(LocalDate date);
}
