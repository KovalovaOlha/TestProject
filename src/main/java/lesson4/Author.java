package lesson4;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String nationality;
    private String biography;
    private List<BookStore> books;

    public Author(String name, String nationality, String biography) {
        this.name = name;
        this.nationality = nationality;
        this.biography = biography;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getBiography() {
        return biography;
    }

    public List<BookStore> getBooks() {
        return books;
    }

    public void addBook(BookStore book) {
        books.add(book);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", biography='" + biography + '\'' +
                ", books=" + books +
                '}';
    }
}
