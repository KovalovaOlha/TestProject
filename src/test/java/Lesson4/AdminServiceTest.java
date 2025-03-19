package Lesson4;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AdminServiceTest {

    @Test
    void testPromoteToAdmin() {
        PrintStream originalSystemOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        AdminService adminService = new AdminServiceImpl();
        adminService.promoteToAdmin("user123");
        String expectedOutput = "Користувач user123 підвищений до адміністратора.\n";
        assert(outputStream.toString().equals(expectedOutput));

        System.setOut(originalSystemOut);
    }

    @Test
    void testBlockUser() {
        PrintStream originalSystemOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        AdminService adminService = new AdminServiceImpl();
        adminService.blockUser(456);

        String expectedOutput = "Користувач з ID 456 заблокований.\n";
        assert(outputStream.toString().equals(expectedOutput));
        System.setOut(originalSystemOut);
    }
}
