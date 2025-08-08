import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Cyberpunk7Test {

    @Test public void testRegres() {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int[] res = {1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10};
        assertArrayEquals(Cyberpunk7.matrix(4,4, matrix), res);
    }
}