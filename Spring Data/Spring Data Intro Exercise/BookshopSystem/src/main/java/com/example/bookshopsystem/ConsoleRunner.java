package com.example.bookshopsystem;

import com.example.bookshopsystem.services.AuthorService;
import com.example.bookshopsystem.services.BookService;
import com.example.bookshopsystem.services.CategoryService;
import com.example.bookshopsystem.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final CategoryService categoryService;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public ConsoleRunner(SeedService seedService, CategoryService categoryService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.categoryService = categoryService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAll();
//        this.bookService.getBooksAfterYear(LocalDate.of(2000, 1, 1));
//        this.authorService.getAuthorsByBookBeforeYear(LocalDate.of(1990, 1, 1));
        this.authorService.getAuthorsByNumberOfBooksDesc();
    }
}
