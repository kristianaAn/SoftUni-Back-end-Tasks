package lection_15_IteratorsAndComparators_lab.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookLibrary {
    private String title;
    private int year;
    private List<String> authors;

    public BookLibrary(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }
}
