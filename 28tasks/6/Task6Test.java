import org.junit.jupiter.api.RepeatedTest;
import org.junit.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Task6Test {
    @Test public void testMinDirectly() {
        int[] hits = new int[]{ 7, 8 };
        assertEquals(Task6.PatternUnlock(2, hits), "1");
    }

    @Test public void testMinDiagonal() {
        int[] hits = new int[]{ 7, 2 };
        assertEquals(Task6.PatternUnlock(2, hits), "141421");
    }

    @Test public void testInt() {
        int[] hits = new int[]{ 6, 1, 9, 8, 7, 3, 4, 5, 2 };
        assertEquals(Task6.PatternUnlock(10, hits), "8");
    }

    @Test public void testRegres() {
        int[] hits = new int[]{ 1, 2, 3, 4, 5, 6, 2, 7, 8, 9, };
        assertEquals(Task6.PatternUnlock(10, hits), "982843");
    }

    @Test public void testRemoveZero(){
        assertEquals(Task6.removeZero("10.012"), "112");
    }
}