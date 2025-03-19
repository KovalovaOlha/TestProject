package Lesson4;

import org.testng.annotations.Test;

public class ExchangeServiceImplTest {
    @Test
    public void testSuccessfulExchange() {
        ExchangeServiceImpl exchangeService = new ExchangeServiceImpl();
        exchangeService.exchange(1, "USD", "EUR", 100);
    }

    @Test
    public void testInsufficientBalance() {
        ExchangeServiceImpl exchangeService = new ExchangeServiceImpl();
        exchangeService.exchange(1, "USD", "EUR", 2000);
    }

}
