import org.junit.jupiter.api.RepeatedTest;
import org.junit.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Task5Test {

    @RepeatedTest(10)
     public void testRandom() {
        Random rand = new Random();
        int size = rand.nextInt(100) + 1;

        int[] ids = new int[size];
        int[] salary = new int[size];
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            ids[i] = i;
            salary[i] = (size - i) * 10;
            result[i] = (i + 1) * 10;
        }

        assertArrayEquals(Task5.SynchronizingTables(size, ids, salary), result);
    }

    @Test public void testMin() {
        int[] ids = new int[]{ 1 };
        int[] salary = new int[]{ 1000 };

        int[] result = new int[]{ 1000 };

        assertArrayEquals(Task5.SynchronizingTables(1, ids, salary), result);
    }

    @Test public void testZero() {
        int[] ids = new int[0];
        int[] salary = new int[0];

        int[] result = new int[0];

        assertArrayEquals(Task5.SynchronizingTables(0, ids, salary), result);
    }

    @Test public void testRegres() {
        int[] ids = new int[]{ 50, 1, 1024 };
        int[] salary = new int[]{ 20000, 100000, 90000 };

        int[] result = new int[]{ 90000, 20000, 100000 };

        assertArrayEquals(Task5.SynchronizingTables(3, ids, salary), result);
    }
}