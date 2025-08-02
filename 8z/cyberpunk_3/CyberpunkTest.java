import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CyberpunkTest {

    @Test public void testRegres() {
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{1,2,3,4};
        assertEquals(Cyberpunk.EEC_help(arr1, arr2), false);
    }

    @Test public void testRegres2() {
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{1,2,3};
        assertEquals(Cyberpunk.EEC_help(arr1, arr2), true);
    }

    @Test public void testRegres3() {
        int[] arr1 = new int[]{1,3,2};
        int[] arr2 = new int[]{1,2,3};
        assertEquals(Cyberpunk.EEC_help(arr1, arr2), true);
    }

    @Test public void testRegres4() {
        int[] arr1 = new int[]{1,3,2,3};
        int[] arr2 = new int[]{1,2,2,3};
        assertEquals(Cyberpunk.EEC_help(arr1, arr2), false);
    }

    @Test public void testRegres5() {
        int[] arr1 = new int[]{1,1};
        int[] arr2 = new int[]{1,1};
        assertEquals(Cyberpunk.EEC_help(arr1, arr2), true);
    }


}