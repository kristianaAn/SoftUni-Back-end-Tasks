package com.example.bookshopsystem.services;

import com.example.bookshopsystem.entities.Book;
import com.example.bookshopsystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean isBookDataSeeded() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public void seedBook(List<Book> books) {
        this.bookRepository.saveAll(books);
    }

    @Override
    public List<Book> getBooksAfterYear(LocalDate date) {
        List<Book> allByReleaseDateYear = bookRepository.findAllByReleaseDateAfter(date).get();

        allByReleaseDateYear.forEach(book -> System.out.println(book.getTitle()));

        return allByReleaseDateYear;
    }

    @Override
    public List<Book> getBooksBeforeYear(LocalDate date) {
        List<Book> allByReleaseDateYearBefore = bookRepository.findAllByReleaseDateBefore(date);

        if (allByReleaseDateYearBefore == null) {
            throw new NoSuchElementException();
        }
        return allByReleaseDateYearBefore;
    }
}
