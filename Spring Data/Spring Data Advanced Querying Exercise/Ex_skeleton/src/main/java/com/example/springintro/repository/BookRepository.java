package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.models.BookPrintInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal low, BigDecimal high);

    List<Book> findAllByReleaseDateIsNotLike(LocalDate localDate);

    List<Book> findAllByTitleContainingIgnoreCase(String string);

    List<Book> findAllByAuthorLastNameStartingWith(String prefix);

    @Query("SELECT b FROM Book AS b WHERE LENGTH(b.title) > :length")
    List<Book> findAllByTitleLengthGreaterThan(int length);

    List<Book> findAllByAuthorFirstNameAndAuthorLastName(String firstName, String lastName);

    @Query("SELECT new com.example.springintro.models.BookPrintInformation(b.title, b.editionType, b.ageRestriction, b.price) " +
            "from Book b WHERE b.title = :title")
    List<BookPrintInformation> findAllByTitle(String title);

}
