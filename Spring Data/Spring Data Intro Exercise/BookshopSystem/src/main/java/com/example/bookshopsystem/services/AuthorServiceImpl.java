package com.example.bookshopsystem.services;

import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.entities.Book;
import com.example.bookshopsystem.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookService bookService;


    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, BookService bookService, BookService bookService1) {
        this.authorRepository = authorRepository;

        this.bookService = bookService1;
    }

    @Override
    public boolean isAuthorDataSeeded() {
        return this.authorRepository.count() > 0;
    }

    @Override
    public void seedAuthor(List<Author> authors) {
       this.authorRepository.saveAll(authors);
    }

    @Override
    public Author getRandomAuthor() {
        long count = this.authorRepository.count();

        if (count == 0) {
            throw new IllegalArgumentException();
        }

        long randomLong = new Random().nextLong(1L, count) + 1L;

        return this.authorRepository.findById(randomLong).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Author> getAuthorsByBookBeforeYear(LocalDate date) {
        List<Author> authorList = this.bookService.getBooksBeforeYear(date)
                .stream()
                .map(Book::getAuthor)
                .collect(Collectors.toList());

        authorList
                .forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));

        return authorList;
    }

    @Override
    public List<Author> getAuthorsByNumberOfBooksDesc() {
        List<Author> authorsByBooksCountDescending = this.authorRepository.findAuthorsByBooksCountDescending();

        authorsByBooksCountDescending
                .forEach(author -> System.out.println(author.authorFullNameAndNumOfBooksStr()));

        return authorsByBooksCountDescending;
    }
}
