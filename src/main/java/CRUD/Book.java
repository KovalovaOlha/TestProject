package CRUD;

import java.util.Objects;

public class Book {
    private int id;
    private String title;
    private String author;
    private double price;

    // Конструктор
    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Геттери та Сеттери
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author='" + author + "', price=" + price + "}";
    }

    // Перевизначення методу equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Перевірка, чи це той самий об'єкт
        if (obj == null || getClass() != obj.getClass()) return false; // Перевірка на null та на клас
        Book book = (Book) obj; // Перетворення об'єкта в тип Book
        return id == book.id && // Порівняння id
                Double.compare(book.price, price) == 0 && // Порівняння ціни
                Objects.equals(title, book.title) && // Порівняння назви
                Objects.equals(author, book.author); // Порівняння автора
    }

    // Перевизначення методу hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, price);
    }
}

