package Lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExchangeServiceImpl implements ExchangeService {
    private final Map<Integer, List<String>> exchangeHistory = new HashMap<>();

    @Override
    public void exchange(int userId, String fromCurrency, String toCurrency, double amount) {
        if (amount <= 0) {
            System.out.println("Сума обміну повинна бути більше нуля.");
            return;
        }

        double exchangeRate = getExchangeRate(fromCurrency, toCurrency);
        double userBalance = getUserBalance(userId, fromCurrency);

        if (userBalance >= amount) {
            double exchangedAmount = amount * exchangeRate;
            updateUserBalance(userId, fromCurrency, -amount);
            updateUserBalance(userId, toCurrency, exchangedAmount);

            String record = "Обміняно " + amount + " " + fromCurrency + " на " + exchangedAmount + " " + toCurrency;
            exchangeHistory.computeIfAbsent(userId, k -> new ArrayList<>()).add(record);

            System.out.println("Обмін успішно здійснено! " + record);
        } else {
            System.out.println("Недостатньо коштів для здійснення обміну.");
        }
    }

    @Override
    public List<String> getExchangeHistory(int userId) {
        return exchangeHistory.getOrDefault(userId, new ArrayList<>());
    }

    private double getExchangeRate(String fromCurrency, String toCurrency) {
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            return 42.60;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            return 1 / 42.60;
        }
        return 1.0;
    }

    private double getUserBalance(int userId, String currency) {
        return 1000.0;
    }

    private void updateUserBalance(int userId, String currency, double amount) {
        System.out.println("Баланс користувача оновлено: " + currency + " " + amount);
    }
}
