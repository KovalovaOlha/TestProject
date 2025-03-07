package tests;

import Lesson2.LoopsInJava;
import Lesson2.Variables;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.testng.AssertJUnit.assertEquals;

public class LoopsInJavaTest {

    private LoopsInJava loopsInJava;
    private Variables variables;

    @BeforeEach
    public void setUp() {
        loopsInJava = new LoopsInJava();
        variables = new Variables();
    }

    @Test
    public void testSimpleForLoop() {
        int[] result = loopsInJava.simple_for_loop();
        System.out.println("Result from simple for loop: " + Arrays.toString(result));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, result, "Simple for loop should return correct array.");
    }

    @Test
    public void testEnhancedForEachLoop() {
        int[] result = loopsInJava.enhanced_for_each_loop();
        System.out.println("Result from enhanced for-each loop: " + Arrays.toString(result));  // Виведе результат
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, result, "Enhanced for-each loop should return correct array.");
    }

    @Test
    public void testWhileLoop() {
        int[] result = loopsInJava.while_loop();
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, result, "While loop should return correct array.");
    }

    @Test
    public void testDoWhileLoop() {
        int[] result = loopsInJava.do_while_loop();
        System.out.println("Result from do-while loop: " + Arrays.toString(result));  // Виведе результат
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, result, "Do-while loop should return correct array.");
    }


}
