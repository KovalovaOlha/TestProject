package lesson4;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class AuthorBookStoreTest {
    private Author author;
    private BookStore book1;
    private BookStore book2;

    @BeforeEach
    void setUp() {
        author = new Author("J.K. Rowling", "British", "Famous for the Harry Potter series");
        book1 = new BookStore("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", BookGenre.FANTASY);
        book2 = new BookStore("Harry Potter and the Chamber of Secrets", "J.K. Rowling", BookGenre.FANTASY);
    }

    @Test
    void testAuthorInitialization() {
        assertEquals("J.K. Rowling", author.getName());
        assertEquals("British", author.getNationality());
        assertEquals("Famous for the Harry Potter series", author.getBiography());
        assertTrue(author.getBooks().isEmpty());
    }

    @Test
    void testAddBook() {
        author.addBook(book1);
        author.addBook(book2);

        List<BookStore> books = author.getBooks();
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    void testBookStoreInitialization() {
        assertEquals("Harry Potter and the Sorcerer's Stone", book1.getTitle());
        assertEquals("J.K. Rowling", book1.getAuthor());
        assertEquals(BookGenre.FANTASY, book1.getGenre());
    }

    @Test
    void testBookGenreEnum() {
        assertEquals("Fantasy", BookGenre.FANTASY.getDisplayName());
        assertEquals("Magical worlds and mythical creatures", BookGenre.FANTASY.getDescription());
    }
}
