package tests;

import Lesson2.Variables;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VariablesTest {
    private Variables variables;

    @BeforeEach
    public void setUp() {
        variables = new Variables();
    }

    @Test
    public void testGenerateOutput() {
        String result = variables.generateOutput();

        // Очікуваний результат
        String expectedOutput =
                "Local: 50\n" +
                        "Global: 100\n" +
                        "Pi: 3.14\n" +
                        "Letter: A\n" +
                        "Is True: true\n";

        // Перевіряємо, чи збігається результат із очікуваним
        assertEquals(expectedOutput, result, "Output should match expected variable values.");
        System.out.println("Result from generateOutput:\n" + result);
    }
}