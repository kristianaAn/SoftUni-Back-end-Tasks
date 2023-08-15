package softuni.exam.models.dto;

import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.LibraryMember;

import java.time.LocalDate;

public class BooksExportDto {

    private Book book;
//    private String bookTitle;
//    private String bookAuthor;
    private LocalDate borrowDate;

    private LibraryMember libraryMember;
//    private String libraryMemberFirstName;
//    private String libraryMemberLastName;


    public BooksExportDto(Book book, LocalDate borrowDate, LibraryMember libraryMember) {
        this.book = book;
        this.borrowDate = borrowDate;
        this.libraryMember = libraryMember;
    }

    public BooksExportDto() {
    }


    @Override
    public String toString() {
        return "Book title: " + book.getTitle() + "\n" +
                "*Book author: " + book.getAuthor() + "\n" +
                "**Date borrowed: " + borrowDate + "\n" +
                "***Borrowed by: " + libraryMember.getFirstName() + " " + libraryMember.getLastName() + "\n";
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LibraryMember getLibraryMember() {
        return libraryMember;
    }

    public void setLibraryMember(LibraryMember libraryMember) {
        this.libraryMember = libraryMember;
    }
}
