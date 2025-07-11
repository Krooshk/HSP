import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class MyCodeTest {

    @RepeatedTest(100)
    public void testRandom() {
        Random rand = new Random();

        int size = 1000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size);
        }

        int[] copyArr = MyCode.copy(arr);
        Arrays.sort(copyArr);
        assertTrue(MyCode.equal(MyCode.sort(arr), copyArr));
    }

    @Test
    public void testZero() {
        int[] arr = new int[] { 0 };
        int[] sortedArr = new int[] { 0 };
        assertTrue(MyCode.equal(MyCode.sort(arr), sortedArr));
    }

    @Test
    public void testEmpty() {
        int[] arr = new int[] {};
        int[] sortedArr = new int[] {};
        assertTrue(MyCode.equal(MyCode.sort(arr), sortedArr));
    }

    @Test
    public void testExtremum() {
        int[] arr = new int[] { 2147483647 , -2147483648, 3, 5, 7, 9 };
        int[] sortedArr = new int[] { -2147483648, 3, 5, 7, 9, 2147483647 };
        assertTrue(MyCode.equal(MyCode.sort(arr), sortedArr));
    }

    @Test
    public void testRegress() {
        int[] arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 , 0};
        int[] sortedArr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        assertTrue(MyCode.equal(MyCode.sort(arr), sortedArr));
    }
}