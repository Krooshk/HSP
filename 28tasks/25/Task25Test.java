import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Task25Test {

    @Test public void testRegres() {
        int[] arr = new int[]{ 3, 4 };
        assertEquals(Task25.TransformTransform(arr, arr.length), false);
    }

    @Test public void testRegresTT() {
        int[] arr = new int[]{ 3, 4 };
        int[] result = new int[]{ 3, 4, 4};
        assertArrayEquals(Task25.tt(arr, arr.length), result);
    }

}




