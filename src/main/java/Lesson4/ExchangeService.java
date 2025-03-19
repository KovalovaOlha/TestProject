package Lesson4;

public interface ExchangeService {

    // Обмін валют
    void exchange(int userId, String fromCurrency, String toCurrency, double amount);
}
