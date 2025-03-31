package lesson4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookCreation() {
        BookStore book = new BookStore("Harry Potter", "J.K. Rowling", BookGenre.FANTASY);

        assertEquals("Harry Potter", book.getTitle());
        assertEquals("J.K. Rowling", book.getAuthor());
        assertEquals(BookGenre.FANTASY, book.getGenre());
        assertEquals("Fantasy", book.getGenre().getDisplayName());
    }

    @Test
    public void testToString() {
        BookStore book = new BookStore("1984", "George Orwell", BookGenre.SCIENCE_FICTION);
        String expected = "BookStore{title='1984', author='George Orwell', genre=Science Fiction}";

        assertEquals(expected, book.toString());
    }

}
