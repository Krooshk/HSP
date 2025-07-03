import org.junit.jupiter.api.RepeatedTest;
import org.junit.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Task6Test {
    @Test public void testMinDirectly() {
        int[] hits = new int[]{ 1, 2 };
        assertEquals(Task6.PatternUnlock(2, hits), "1");
    }

    @Test public void testMinDiagonal() {
        int[] hits = new int[]{ 1, 5 };
        assertEquals(Task6.PatternUnlock(2, hits), "141421");
    }

    @Test public void testInt() {
        int[] hits = new int[]{ 1, 2, 3, 6, 9, 8, 7, 4, 5 };
        assertEquals(Task6.PatternUnlock(9, hits), "8");
    }

    @Test public void testRemoveZero(){
        assertEquals(Task6.removeZero("10.012"), "112");
    }

    @Test public void testRegres() {
        int[] hits = new int[]{ 2, 5, 8, 7, 4, 1, 9, 6, 3 };
        assertEquals(Task6.PatternUnlock(9, hits), "982843");
    }

    @Test public void testRegres2(){
        int[] hits = new int[]{ 2, 1, 9, };
        assertEquals(Task6.PatternUnlock(3, hits), "382843");
    }
}