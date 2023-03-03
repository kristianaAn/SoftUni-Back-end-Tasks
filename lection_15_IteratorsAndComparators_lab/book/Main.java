package lection_15_IteratorsAndComparators_lab.book;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookList bookOne = new BookList("Animal Farm", 2003, "George Orwell");
        BookList bookTwo = new BookList("The Documents in the Case", 2002);
        BookList bookThree = new BookList("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustance");

        List<BookList> bookList = new ArrayList<>();
        bookList.add(bookOne);
        bookList.add(bookTwo);
        bookList.add(bookThree);

    }
}
