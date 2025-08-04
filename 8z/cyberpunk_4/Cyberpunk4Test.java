import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Cyberpunk4Test {

    @Test public void testRegres() {
        int[] arr1 = {1,2,3,4,5};
        assertEquals(Cyberpunk4.artificial_muscle_fibers(arr1), 0);
    }

    @Test public void testRegres2() {
        int[] arr1 = {1,2,3,2,1};
        assertEquals(Cyberpunk4.artificial_muscle_fibers(arr1), 2);
    }

    @Test public void testRegres3() {
        int[] arr1 = {1,2,3,2,1,2,4,2,1};
        assertEquals(Cyberpunk4.artificial_muscle_fibers(arr1), 2);
    }

    @Test public void testRegres4() {
        int[] arr1 = new int[64000];
        for (int i = 0, j = 1; i < 64000; i+=2, j++) {
            arr1[i] = j;
            arr1[i + 1] = j;
        }

        assertEquals(Cyberpunk4.artificial_muscle_fibers(arr1), 32000);
    }
}