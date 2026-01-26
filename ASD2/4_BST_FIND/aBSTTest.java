import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class aBSTTest {

    @Test public void testCountSizeZero(){
        aBST abst = new aBST(0);

        assertEquals(abst.Tree.length, 1);
    }

    @Test public void testCountSizeOne(){
        aBST abst = new aBST(1);

        assertEquals(abst.Tree.length, 3);
    }

    @Test public void testCountSizeThree(){
        aBST abst = new aBST(3);

        assertEquals(abst.Tree.length, 15);
    }

    @Test public void testCountSizeFive(){
        aBST abst = new aBST(5);

        assertEquals(abst.Tree.length, 63);
    }

    @Test public void findKeyOne(){
        aBST abst = new aBST(0);

        assertEquals(abst.FindKeyIndex(50), 0);
        abst.AddKey(50);
        assertEquals(abst.FindKeyIndex(50), 0);
        assertEquals(abst.FindKeyIndex(100), null);
    }

    @Test public void findKeyTwo(){
        aBST abst = new aBST(1);
        abst.AddKey(50);

        assertEquals(abst.FindKeyIndex(75), -2);
        abst.AddKey(75);
        assertEquals(abst.FindKeyIndex(75), 2);
    }

    @Test public void testAddKeyOne(){
        aBST abst = new aBST(0);
        int[] keys = { 50 };

        for (int key: keys) {
            abst.AddKey(key);
        }

        Integer[] result = { 50 };
        assertArrayEquals(abst.Tree, result);
    }

    @Test public void testAddKey(){
        aBST abst = new aBST(3);
        int[] keys = { 50, 75, 84, 92, 62, 55, 65, 80, 25, 10, 5, 37, 31, 43, 11 };

        for (int key: keys) {
            abst.AddKey(key);
        }

        Integer[] result = { 50, 25, 75, 10, 37, 62, 84, 5, 11, 31, 43, 55, 65, 80, 92 };
        assertArrayEquals(abst.Tree, result);
    }

    @Test public void testAddKeyPositive(){
        aBST abst = new aBST(3);
        int[] keys = { 50, 75, 84, 92, 62, 55, 65, 80, 25, 10, 5, 37, 31, 43, 11 };

        for (int key: keys) {
            abst.AddKey(key);
        }

        assertEquals(abst.AddKey(10),  3);
    }

    @Test public void testAddKeyNegative(){
        aBST abst = new aBST(3);
        int[] keys = { 50, 75, 84, 92, 62, 55, 65, 80, 25, 10, 5, 37, 31, 43, 11 };

        for (int key: keys) {
            abst.AddKey(key);
        }

        assertEquals(abst.AddKey(100),  -1);
    }

    @Test public void testWideAll(){
        aBST abst = new aBST(3);
        int[] keys = { 50, 75, 84, 62, 65, 80, 25, 10, 5, 37, 11 };
        for (int key: keys) {
            abst.AddKey(key);
        }
        Integer[] array = { 50, 25, 75, 10, 37, 62, 84, 5, 11, 65, 80 };
        ArrayList<Integer> actual = new ArrayList<>(Arrays.asList(array));

        assertEquals(abst.WideAllNodes(),  actual);
    }

    @Test public void testSpeed(){
        aBST abst = new aBST(3);
        int[] keys = { 50, 75, 84, 92, 62, 55, 65, 80, 25, 10, 5, 37, 31, 43, 11 };

        for (int key: keys) {
            abst.AddKey(key);
        }
        long startTime = System.nanoTime();
        abst.FindKeyIndex(92);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Время выполнения: " + duration + " мс"); // 1122 1743 1532 ~ 1465 нс
    }
}