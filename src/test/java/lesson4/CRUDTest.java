package lesson4;

import CRUD.Book;
import CRUD.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CRUDTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        // Ініціалізуємо BookRepository перед кожним тестом
        bookRepository = new BookRepository();
    }

    // Тест на створення книги
    @Test
    public void testCreateBook() {
        Book book = bookRepository.createBook("Java for Beginners", "John Doe", 29.99);
        assertNotNull(book);
        assertEquals("Java for Beginners", book.getTitle());
        assertEquals("John Doe", book.getAuthor());
        assertEquals(29.99, book.getPrice());
    }

    // Тест на отримання книги за ID
    @Test
    public void testGetBookById() {
        Book book = bookRepository.createBook("Java for Beginners", "John Doe", 29.99);
        Book foundBook = bookRepository.getBookById(book.getId()).orElse(null);
        assertNotNull(foundBook);
        assertEquals(book.getId(), foundBook.getId());
        assertEquals(book.getTitle(), foundBook.getTitle());
    }

    // Тест на оновлення книги
    @Test
    public void testUpdateBook() {
        Book book = bookRepository.createBook("Java for Beginners", "John Doe", 29.99);
        boolean updated = bookRepository.updateBook(book.getId(), "Java for Beginners - Updated", "John Doe", 39.99);
        assertTrue(updated);

        Book updatedBook = bookRepository.getBookById(book.getId()).orElse(null);
        assertNotNull(updatedBook);
        assertEquals("Java for Beginners - Updated", updatedBook.getTitle());
        assertEquals(39.99, updatedBook.getPrice());
    }

    // Тест на видалення книги
    @Test
    public void testDeleteBook() {
        Book book = bookRepository.createBook("Java for Beginners", "John Doe", 29.99);
        boolean deleted = bookRepository.deleteBook(book.getId());
        assertTrue(deleted);

        Book deletedBook = bookRepository.getBookById(book.getId()).orElse(null);
        assertNull(deletedBook);
    }

    // Тест на отримання всіх книг
    @Test
    public void testGetAllBooks() {
        bookRepository.createBook("Java for Beginners", "John Doe", 29.99);
        bookRepository.createBook("Advanced Java", "Jane Smith", 49.99);

        assertEquals(2, bookRepository.getAllBooks().size());
    }

    @Test
    public void testEqualsDifferentBooksWithSameValues() {
        Book book1 = new Book(1, "Java for Beginners", "John Doe", 29.99);
        Book book2 = new Book(1, "Java for Beginners", "John Doe", 29.99);
        // Порівнюємо дві книги з однаковими значеннями, результат має бути true
        assertTrue(book1.equals(book2), "Books with the same values should be equal");
    }

}
