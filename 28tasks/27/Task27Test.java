import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Task27Test {

    @Test public void testRegres() {
        int[] arr = new int[]{ 1, 3, 2 };
        assertEquals(Task27.Football(arr, arr.length), true);
    }

    @Test public void testRegres2() {
        int[] arr = new int[]{ 3, 2, 1 };
        assertEquals(Task27.Football(arr, arr.length), true);
    }

    @Test public void testRegres3() {
        int[] arr = new int[]{ 1, 7, 5, 3, 9 };
        assertEquals(Task27.Football(arr, arr.length), true);
    }

    @Test public void testRegres4() {
        int[] arr = new int[]{ 9, 5, 3, 7, 1 };
        assertEquals(Task27.Football(arr, arr.length), false);
    }

    @Test public void testRegres5() {
        int[] arr = new int[]{ 1, 4, 3, 2, 5 };
        assertEquals(Task27.Football(arr, arr.length), true);
    }

    @Test public void testRegres6() {
        int[] arr = new int[]{ 9, 3, 5, 7, 1 };
        assertEquals(Task27.Football(arr, arr.length), true);
    }

    @Test public void testRegres7() {
        int[] arr = new int[]{ 1, 2, 3 };
        assertEquals(Task27.Football(arr, arr.length), true);
    }

}




