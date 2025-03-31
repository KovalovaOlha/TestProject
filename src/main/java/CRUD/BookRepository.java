package CRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository {
    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    // Створити (Create)
    public Book createBook(String title, String author, double price) {
        Book newBook = new Book(nextId++, title, author, price);
        books.add(newBook);
        return newBook;
    }

    // Читати (Read)
    public Optional<Book> getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    // Оновити (Update)
    public boolean updateBook(int id, String title, String author, double price) {
        Optional<Book> book = getBookById(id);
        if (book.isPresent()) {
            Book b = book.get();
            b.setTitle(title);
            b.setAuthor(author);
            b.setPrice(price);
            return true;
        }
        return false;
    }

    // Видалити (Delete)
    public boolean deleteBook(int id) {
        return books.removeIf(book -> book.getId() == id);
    }

    // Вивести всі книги
    public List<Book> getAllBooks() {
        return books;
    }
}
