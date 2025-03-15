package Lesson3;

import DataProvider.LoginData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginPage {

    @Test(dataProvider = "loginData", dataProviderClass = LoginData.class)
    public void testLogin(String username, String password, boolean expectedResult) {
        System.out.println("Testing with: " + username + ", " + password);

        boolean actualResult = performLogin(username, password);
        assertTrue(actualResult == expectedResult, "Login result is incorrect");
    }

    private boolean performLogin(String username, String password) {
        return username.equals("user1") && password.equals("password1");
    }
}