package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.models.BookPrintInformation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(String ageRestriction);

    List<Book> findAllByEditionTypeAndCopies(String editionType, int copies);

    List<Book> findAllInPriceRange(double lower, double higher);

    List<Book> findAllByReleaseDateYearIsNot(LocalDate localDate);

    List<Book> findAllByReleaseDateBefore(LocalDate localDate);

    List<Book> findAllByTitleLikeIgnoreCase(String string);

    List<Book> findAllByAuthorLastNameStartingWith(String prefix);

    List<Book> findAllByTitleLengthGreaterThan(int length);

    List<Book> findAllByAuthorFirstNameAndAuthorLastName(String firstName, String lastName);

    List<BookPrintInformation> findAllByTitle(String title);

}
