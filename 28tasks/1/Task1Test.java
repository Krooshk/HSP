import org.junit.Test;
import java.util.HashMap;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Task1Test {
    @Test public void testRandom() {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Random rand = new Random();
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 50, 100 };
        int len = array.length;
        map.put(0, 1); // 1
        map.put(1, 1); // 1
        map.put(2, 2); // 2
        map.put(3, 6); // 6
        map.put(4, 2); // 24
        map.put(5, 1); // 120
        map.put(6, 7); // 720
        map.put(7, 5); // 5040
        map.put(8, 4); // 40320
        map.put(9, 3); // 362880
        map.put(10, 3); // 3628800
        map.put(11, 3); // 399...
        map.put(12, 4); // 479...
        map.put(13, 6); // 622...
        map.put(14, 8); // 871...
        map.put(15, 1); // 130...
        map.put(20, 2); // 243...
        map.put(50, 3); // 304...
        map.put(100, 9); // 933...

        for (int i = 0; i < 20; i++){
            int num = rand.nextInt(len);
            int key = array[num];
            int value = map.get(key);

            assertTrue(Task1.squirrel(key) == value);
        }
    }

    @Test
    public void testZero() {
        assertTrue(Task1.squirrel(0) == 1);
    }

    @Test
    public void testMaxInt() {
        assertTrue(Task1.squirrel(13) == 6);
    }

    @Test
    public void testRegres() {
        assertTrue(Task1.squirrel(5) == 1);
    }
}