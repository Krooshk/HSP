import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Cyberpunk5Test {
    @Test
    public void testRegres() {
        int[] arr1 = {1,2,3,1,2,3,4};
        assertEquals(Cyberpunk5.massdriver(arr1), 0);
    }

    @Test public void testRegres2() {
        int[] arr1 = {1,2,3,4,3,4,2};
        assertEquals(Cyberpunk5.massdriver(arr1), 1);
    }

    @Test public void testRegres3() {
        int[] arr1 = {1,2,3,4,5,6,7};
        assertEquals(Cyberpunk5.massdriver(arr1), -1);
    }
}