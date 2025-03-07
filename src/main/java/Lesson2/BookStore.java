package Lesson2;

public class BookStore {
    public String getBookstoreMessage(String bookName, boolean isAvailable, double price,
                                      double totalOrder, int numberOfBooksInCart,
                                      boolean hasDiscount, boolean freeDelivery, double discountAmount) {
        StringBuilder message = new StringBuilder();

        // Перевірка наявності книги
        if (isAvailable) {
            message.append("Книга '").append(bookName).append("' є в наявності.\n");

            // Перевірка наявності знижки
            if (hasDiscount) {
                message.append("На книгу є знижка! Ви економите ").append(discountAmount).append(" грн.\n");
            }

            // Перевірка на безкоштовну доставку
            if (freeDelivery) {
                message.append("Ви отримуєте безкоштовну доставку!\n");
            }

            // Перевірка на додаткову знижку для великих замовлень
            if (numberOfBooksInCart > 3) {
                message.append("Оскільки у вас більше 3-х книг в кошику, ви отримуєте додаткову знижку!\n");
            }

            // Підсумкове повідомлення
            message.append("Ваше замовлення на суму ").append(totalOrder).append(" грн.");
        } else {
            message.append("На жаль, книга '").append(bookName).append("' відсутня в наявності.");
        }

        return message.toString();
    }
}
