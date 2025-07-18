import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Task24Test {

    @Test public void testRegres() {
        String[] arr = new String[]{ "123456", "234567", "345678", "456789" };
        String[] result = new String[]{ "432123", "565434", "676545", "789876" };
        Task24.MatrixTurn(arr, 4, 6, 3);
        assertArrayEquals(arr, result);
    }

    @Test public void testMaxOffset() {
        assertEquals(Task24.offsetRing("qwertyu", 7), "qwertyu");
    }

    @Test public void testZeroOffset() {
        assertEquals(Task24.offsetRing("qwertyu", 0), "qwertyu");
    }

    @Test public void testRegresOffset() {
        assertEquals(Task24.offsetRing("qwertyu", 3), "tyuqwer");
    }

    @Test public void testRegresOffset2() {
        assertEquals(Task24.offsetRing("qwertyu", 10), "tyuqwer");
    }

}




