package Lesson3;

import Lesson3Pattern.UserProfile;
import Lesson3Pattern.UserProfileBuilder;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class UserProfileTest {

        @Test
        public void testUserProfileCreation() {
            // Створення користувача через Test Data Builder
            UserProfile user = new UserProfileBuilder()
                    .withName("John Doe")
                    .withEmail("john.doe@example.com")
                    .withPhone("9876543210")
                    .build();

            // Перевірка значень
            assertEquals("John Doe", user.getName());
            assertEquals("john.doe@example.com", user.getEmail());
            assertEquals("9876543210", user.getPhone());
        }

    @Test
    public void testDefaultUserProfile() {
        // Створення користувача за замовчуванням
        UserProfile user = new UserProfileBuilder().build();

        // Перевірка значень за замовчуванням
        assertEquals("Default Name", user.getName());
        assertEquals("default@example.com", user.getEmail());
        assertEquals("1234567890", user.getPhone());
    }
}
//UserProfile — це об'єкт, який потрібно створювати.
//UserProfileBuilder — це клас Builder, який дозволяє поетапно налаштовувати значення об'єкта.

