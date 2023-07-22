package com.example.bookshopsystem.services;

import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.entities.Book;
import com.example.bookshopsystem.entities.Category;
import com.example.bookshopsystem.enums.AgeRestriction;
import com.example.bookshopsystem.enums.EditionType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.bookshopsystem.directories.fileDirectories.*;

@Service
public class SeedServiceImpl implements SeedService {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public SeedServiceImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void seedBook() throws IOException {
        System.out.println();
        if (this.bookService.isBookDataSeeded()) return;

        List<Book> bookList = Files.readAllLines(Path.of(RESOURCE_PATH + BOOKS_FILE_NAME))
                .stream()
                .map(line -> Book.builder()
                        .editionType(EditionType.values()[Integer.parseInt(line.split(" ")[0])])
                        .releaseDate(LocalDate.parse(line.split(" ")[1], DateTimeFormatter.ofPattern("d/M/yyyy")))
                        .copies(Integer.parseInt(line.split(" ")[2]))
                        .price(BigDecimal.valueOf(Double.parseDouble(line.split(" ")[3])))
                        .ageRestriction(AgeRestriction.values()[Integer.parseInt(line.split(" ")[4])])
                        .title(Arrays.stream(line.split(" ")).skip(5)
                                .collect(Collectors.joining(" ")))
                        .author(this.authorService.getRandomAuthor())
                        .categories(this.categoryService.getRandomCategories())
                        .build())
                .collect(Collectors.toList());

        this.bookService.seedBook(bookList);
    }

    @Override
    public void seedAuthor() throws IOException {
        if (this.authorService.isAuthorDataSeeded()) return;

        List<Author> authorList = Files.readAllLines(Path.of(RESOURCE_PATH + AUTHORS_FILE_NAME))
                .stream()
                .map(firstLastName -> Author.builder()
                        .firstName(firstLastName.split(" ")[0])
                        .lastName(firstLastName.split(" ")[1])
                        .build())
                .collect(Collectors.toList());

        authorService.seedAuthor(authorList);
    }

    @Override
    public void seedCategory() throws IOException {
        if (categoryService.isCategoryDataSeeded()) return;

        List<Category> categoryList = Files.readAllLines(Path.of(RESOURCE_PATH + CATEGORIES_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(Category::new)
                .toList();

        categoryService.seedCategory(categoryList);
    }
}

