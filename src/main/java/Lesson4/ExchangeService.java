package Lesson4;

import java.util.List;

public interface ExchangeService {

    // Обмін валют
    void exchange(int userId, String fromCurrency, String toCurrency, double amount);

    List<String> getExchangeHistory(int userId);
}
