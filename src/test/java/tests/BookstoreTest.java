package tests;

import Lesson2.BookStore;
import Lesson2.DayOfWeek;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class BookstoreTest {


    @Test
    public void testBookUnavailable() {
        BookStore bookstore = new BookStore();
        String result = bookstore.getBookstoreMessage("Java for Beginners", false, 400.0,
                1000.0, 4, true, true, 50.0);

        String expected = "На жаль, книга 'Java for Beginners' відсутня в наявності.";

        // Використовуємо if-else для перевірки
        if (result.equals(expected)) {
            System.out.println("Тест пройдено успішно");
        } else {
            System.out.println("Тест не пройдено. Очікуваний результат: " + expected);
            System.out.println("Отриманий результат: " + result);
        }

        assertEquals(expected, result);
    }

    @Test
    public void testDayOfWeekValidDays() {
        DayOfWeek dayOfWeek = new DayOfWeek();

        // Перевіряємо правильність для коректних значень
        assertEquals("Понеділок", dayOfWeek.getDayName(1));
        assertEquals("Вівторок", dayOfWeek.getDayName(2));
        assertEquals("Середа", dayOfWeek.getDayName(3));
        assertEquals("Четвер", dayOfWeek.getDayName(4));
        assertEquals("П'ятниця", dayOfWeek.getDayName(5));
        assertEquals("Субота", dayOfWeek.getDayName(6));
        assertEquals("Неділя", dayOfWeek.getDayName(7));
    }

    @Test
    public void testDayOfWeekValidDays1() {
        DayOfWeek dayOfWeek = new DayOfWeek();
        assertEquals(dayOfWeek.getDayName(1), "Понеділок");
         assertNotEquals(dayOfWeek.getDayName(3), "Понеділок");
    }
}
