package Lesson4;

import java.util.List;

public interface ExchangeService2 {
    void exchange(int userId, String fromCurrency, String toCurrency, double amount);
    double getExchangeRate(String fromCurrency, String toCurrency);
    double getBalance(int userId, String currency);
    void deposit(int userId, String currency, double amount);
    boolean withdraw(int userId, String currency, double amount);
    List<String> getExchangeHistory(int userId);
}
