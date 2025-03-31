package tests;

import Factory.Book;
import Factory.BookFactory;
import Factory.FictionBook;
import Factory.ScienceBook;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BookFactoryTest {

    @Test
    public void testCreateFictionBook() {
        Book book = BookFactory.createBook("Fiction");
        assertNotNull(book, "The book should not be null");
        assertTrue(book instanceof FictionBook, "The book should be of type FictionBook");
    }

    @Test
    public void testCreateScienceBook() {
        Book book = BookFactory.createBook("Science");
        assertNotNull(book, "The book should not be null");
        assertTrue(book instanceof ScienceBook, "The book should be of type ScienceBook");
    }

    @Test
    public void testCreateInvalidBook() {
        Book book = BookFactory.createBook("Invalid");
        assertNull(book, "The book should be null for invalid type");
    }
}
