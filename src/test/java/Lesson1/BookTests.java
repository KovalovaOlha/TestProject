package Lesson1;

import LessoN1.AudioBook;
import LessoN1.Book;
import LessoN1.Ebook;
import LessoN1.PrintedBook;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.AssertJUnit.*;

public class BookTests {

    //Поліморфізм у цьому тесті проявляється в тому, що всі три об'єкти
    // (PrintedBook, Ebook, AudioBook) оголошені через спільний тип BookStore, але поводяться по-різному.

        @Test
        void testPolymorphism() {
            //book1, book2 та book3 оголошені як тип BookStore (інтерфейс)
            // Поліморфізм дозволяє нам обробляти їх однаково через BookStore, не звертаючись до конкретних реалізацій..
            LessoN1.Book book1 = new LessoN1.PrintedBook("Java Programming", "John Doe", 500);
            LessoN1.Book book2 = new Ebook("Clean Code", "Robert C. Martin", 3.2);
            LessoN1.Book book3 = new AudioBook("The Pragmatic Programmer", "Andy Hunt", 12.5);

            assertTrue(book1 instanceof LessoN1.Book);
            assertTrue(book2 instanceof LessoN1.Book);
            assertTrue(book3 instanceof Book);
            //book1, book2, book3 — це змінні, які представляють об'єкти різних класів, вони створюються за допомогою конструкторів класів:
            //Якщо тест проходить успішно → означає, що усі підкласи PrintedBook, Ebook і AudioBook успадковують BookStore і підтримують поліморфізм.
            //instanceof перевіряє, що всі три об'єкти справді є екземплярами BookStore.
        }

    @Test
    void testPrintedBookDisplayInfo1() {
            LessoN1.PrintedBook book = new LessoN1.PrintedBook("Java Programming", "John Doe", 500);
            assertNotNull(book);
            System.out.println("✅ PrintedBook створено успішно!");
    }

    @Test
    void testPrintedBookOpenClose() {
        LessoN1.PrintedBook printedBook = new PrintedBook("The Art of Computer Programming", "Donald Knuth", 700);

        //ByteArrayOutputStream - означає що створюється об'єкт типу ByteArrayOutputStream дозводяє записувати байти в память, а не на дивск чи мережу
        //outputStream - уе змінна яка посилається на створений об'єкт ByteArrayOutputStream, також щоб зробити вивід у консоль
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        printedBook.open();
        printedBook.close();

        System.setOut(System.out); // Повертаємо стандартний потік виводу

        String expectedOutput =
                "📖 Opening printed book: The Art of Computer Programming\n" +
                        "📕 Closing printed book: The Art of Computer Programming";

        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }

}

