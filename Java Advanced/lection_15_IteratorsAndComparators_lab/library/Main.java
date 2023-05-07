package lection_15_IteratorsAndComparators_lab.library;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookLibrary bookOne = new BookLibrary("Animal Farm", 2003, "George Orwell");

        BookLibrary bookThree = new BookLibrary("The Documents in the Case", 2002);
        BookLibrary bookTwo = new BookLibrary("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        Library library = new Library(bookOne, bookTwo, bookThree);

//        for (Book lection_15_IteratorsAndComparators_lab.book: lection_15_IteratorsAndComparators_lab.library) {
//            System.out.println(lection_15_IteratorsAndComparators_lab.book.getTitle());
//        }

        Iterator<BookLibrary> bookIterator = library.iterator();

        while (bookIterator.hasNext()) {
            System.out.println(bookIterator.next().getTitle());
        }
    }
}
