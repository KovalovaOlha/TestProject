package Lesson4;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ExchangeServiceImpl2 implements ExchangeService2 {
    private final Map<Integer, Map<String, Double>> userBalances = new HashMap<>();
    private final Map<String, Double> exchangeRates = new HashMap<>();
    private final Map<Integer, List<String>> exchangeHistory = new HashMap<>();

    public ExchangeServiceImpl2() {
        // Додаємо тестові курси валют
        exchangeRates.put("USD-EUR", 0.92);
        exchangeRates.put("EUR-USD", 1.09);
        exchangeRates.put("USD-UAH", 37.5);
        exchangeRates.put("UAH-USD", 0.027);
    }

    @Override
    public void exchange(int userId, String fromCurrency, String toCurrency, double amount) {
        double rate = getExchangeRate(fromCurrency, toCurrency);
        if (rate == 0) {
            System.out.println("Exchange rate not found.");
            return;
        }

        double convertedAmount = amount * rate;
        if (withdraw(userId, fromCurrency, amount)) {
            deposit(userId, toCurrency, convertedAmount);
            exchangeHistory.computeIfAbsent(userId, k -> new ArrayList<>())
                    .add("Exchanged " + amount + " " + fromCurrency + " to " + convertedAmount + " " + toCurrency);
            System.out.println("Exchange successful!");
        } else {
            System.out.println("Insufficient funds for exchange.");
        }
    }

    @Override
    public double getExchangeRate(String fromCurrency, String toCurrency) {
        return exchangeRates.getOrDefault(fromCurrency + "-" + toCurrency, 0.0);
    }

    @Override
    public double getBalance(int userId, String currency) {
        return userBalances.getOrDefault(userId, new HashMap<>()).getOrDefault(currency, 0.0);
    }

    @Override
    public void deposit(int userId, String currency, double amount) {
        userBalances.computeIfAbsent(userId, k -> new HashMap<>())
                .merge(currency, amount, Double::sum);
        System.out.println("Deposited " + amount + " " + currency + " for user " + userId);
    }

    @Override
    public boolean withdraw(int userId, String currency, double amount) {
        double balance = getBalance(userId, currency);
        if (balance >= amount) {
            userBalances.get(userId).put(currency, balance - amount);
            return true;
        }
        return false;
    }

    @Override
    public List<String> getExchangeHistory(int userId) {
        return exchangeHistory.getOrDefault(userId, new ArrayList<>());
    }
}

