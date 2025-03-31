package Lesson1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class NasliduvannyaAbstractionTest {

    @Test
    void testPrintedBookDisplayInfo() {
        // Створюємо об'єкт PrintedBook
        PrintedBook printedBook = new PrintedBook("The Art of Computer Programming", "Donald Knuth", 700);

        //ByteArrayOutputStream - означає що створюється об'єкт типу ByteArrayOutputStream дозводяє записувати байти в память, а не на дивск чи мережу
        //outputStream - уе змінна яка посилається на створений об'єкт ByteArrayOutputStream, також щоб зробити вивід у консоль
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Викликаємо метод displayInfo() який є у абстрактному класу BookStore та перевіряємо чи правильно виводиться інформація
        printedBook.displayInfo();

        // Повертаємо стандартний потік виводу
        System.setOut(System.out);

        // Перевіряємо, чи виведена правильна інформація
        String expectedOutput = "📖 Printed BookStore: The Art of Computer Programming by Donald Knuth, 700 pages.";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
    @Test
    void testBookInstanceOf() {
        // Створюємо різні типи книг
        Book printedBook = new PrintedBook("Java Programming", "James Gosling", 600);
        Book audioBook = new AudioBook("The Pragmatic Programmer", "Andy Hunt", 10.5);
        Book ebook = new Ebook("Design Patterns", "Erich Gamma", 4.0);

        // Перевіряємо, чи є вони підтипами класу BookStore
        //instanceof перевіряє, що всі три об'єкти справді є екземплярами BookStore.
        assertTrue(printedBook instanceof Book);
        assertTrue(audioBook instanceof Book);
        assertTrue(ebook instanceof Book);
    }


    @Test
    void testSetAndGetDurationHours() {
        AudioBook audioBook = new AudioBook("The Pragmatic Programmer", "Andy Hunt", 12.5);

        // Перевірка початкової тривалості
        //assertEquals — це метод з бібліотеки тестування JUnit, який використовується для перевірки того, чи дорівнюють два значення.
        //expected — це значення, яке очікуєш.
        //actual — це значення, яке повертає наш код.
        assertEquals(12.5, audioBook.getDurationHours());

        // Зміна тривалості через сеттер
        audioBook.setDurationHours(15.0);

        // Перевірка нової тривалості
        assertEquals(15.0, audioBook.getDurationHours());
    }


}
