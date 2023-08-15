package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class BooksImportDTO {
//    title – accepts char sequence (between 3 to 40 inclusive)
//    author - accepts char sequence (between 3 to 40 inclusive)
//    description - a long and detailed description about the book with a character length value higher than or equal to 5.
//    available – accepts a true or false, representing the availability status of the book.
//    genre – String enumeration
//    rating – accepts number values that are positive.

    @Length(min = 3, max = 40)
    @NotNull
    private String author;

    @NotNull
    private boolean available;

    @Length(min = 5)
    @NotNull
    private String description;

    @NotNull
    private String genre;

    @Length(min = 3, max = 40)
    @NotNull
    private String title;

    @Positive
    @NotNull
    private double rating;

    public BooksImportDTO() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
