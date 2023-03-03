package lection_15_IteratorsAndComparators_lab.library;

import java.util.Iterator;

public class Library implements Iterable<BookLibrary>{
    private BookLibrary[] books;

    public Library(BookLibrary... books) {
        this.books = books;
    }

    public BookLibrary[] getBooks() {
        return books;
    }

    @Override
    public Iterator<BookLibrary> iterator() {
        return new LibIterator();
    }

    private class LibIterator implements Iterator<BookLibrary> {
        private int index;

        public LibIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < books.length;
        }

        @Override
        public BookLibrary next() {
            return books[index++];
        }
    }

}
