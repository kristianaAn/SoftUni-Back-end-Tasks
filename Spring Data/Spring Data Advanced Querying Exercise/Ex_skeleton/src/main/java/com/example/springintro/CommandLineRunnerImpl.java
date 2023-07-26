package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.models.BookPrintInformation;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final Scanner scanner;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

//        1. Books Titles by Age Restriction
//        String ageRestrictionInput = scanner.nextLine();
//        List<Book> allByAgeRestriction = bookService.findAllByAgeRestriction(ageRestrictionInput);
//        allByAgeRestriction.forEach(book -> System.out.println(book.titleToString()));

//        2. Golden Books
//        List<Book> goldenBooks = bookService.findAllByEditionTypeAndCopies("GOLD", 5000);
//        goldenBooks.forEach(book -> System.out.println(book.titleToString()));

//        3. Books by Price
//        List<Book> allInPriceRange = bookService.findAllInPriceRange(5, 40);
//        allInPriceRange
//                .stream().map(book -> book.getTitle() + " - $" + book.getPrice())
//                .forEach(System.out::println);

//        4. Not Released Books
//        String year = scanner.nextLine();
//        DateTimeFormatter dtm = new DateTimeFormatterBuilder()
//                  .appendPattern("yyyy")
//                  .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
//                  .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
//                  .toFormatter();
//
//        List<Book> books = bookService
//                .findAllByReleaseDateYearIsNot(LocalDate.parse(year, dtm));
//        books.forEach(book -> System.out.println(book.titleToString()));

//        5. Books Released Before Date
//        String[] date = scanner.nextLine().split("-");
//        int day = Integer.parseInt(date[0]);
//        int month = Integer.parseInt(date[1]);
//        int year = Integer.parseInt(date[2]);
//        List<Book> allByReleaseDateBefore = bookService.findAllByReleaseDateBefore(LocalDate.of(year, month, day));
//        allByReleaseDateBefore.forEach(book -> System.out.println(book.titleEditionPriceToString()));

//        6. Authors Search
//        String endInput = scanner.nextLine();
//        List<Author> allByFirstNameEndingWith = authorService.findAllByFirstNameEndingWith(endInput);
//        allByFirstNameEndingWith.forEach(author -> System.out.println(author.fullNameToString()));

//        7. Books Search
//        String string = scanner.nextLine();
//        List<Book> allByTitleLikeIgnoreCase = bookService.findAllByTitleLikeIgnoreCase(string);
//        allByTitleLikeIgnoreCase.forEach(book -> System.out.println(book.titleToString()));

//        8. Book Titles Search
//        String prefixInput = scanner.nextLine();
//        List<Book> allByAuthorLastNameStartingWith = bookService.findAllByAuthorLastNameStartingWith(prefixInput);
//        allByAuthorLastNameStartingWith
//                .forEach(book -> System.out.println(book.titleToString() + "(" + book.getAuthor().fullNameToString() + ")"));

//        9. Count Books
//          int length = Integer.parseInt(scanner.nextLine());
//        List<Book> allByTitleLengthGreaterThan = bookService.findAllByTitleLengthGreaterThan(length);
//        System.out.println(allByTitleLengthGreaterThan.size());

//        10. Total Book Copies
//        List<Book> allByAuthorFirstNameAndAuthorLastName = bookService.findAllByAuthorFirstNameAndAuthorLastName("Randy", "Graham");
//        System.out.println(allByAuthorFirstNameAndAuthorLastName.stream().mapToInt(Book::getCopies).sum());

//        11. Reduced Book
//        bookService.findAllByTitle("Things Fall Apart");

    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
