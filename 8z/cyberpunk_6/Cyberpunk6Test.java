import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Cyberpunk6Test {

    @Test public void testRegres() {
        int[] arr = {2,1,0};
        int[] res = {0,1,2};
        assertArrayEquals(Cyberpunk6.TRC_sort(arr), res);
    }

    @Test public void testRegres2() {
        int[] arr = {0,1,2,1,0,2};
        int[] res = {0,0,1,1,2,2};
        assertArrayEquals(Cyberpunk6.TRC_sort(arr), res);
    }
}
