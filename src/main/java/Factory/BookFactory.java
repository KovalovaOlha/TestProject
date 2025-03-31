package Factory;

// Фабричний клас для створення книжок
public class BookFactory {
    // Фабричний метод
    public static Book createBook(String type) {
        if (type.equals("Fiction")) {
            return new FictionBook();
        } else if (type.equals("Science")) {
            return new ScienceBook();
        }
        return null;
    }
}
