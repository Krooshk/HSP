import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Cyberpunk8Test {

    @Test public void testRegres() {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        String res = "1 1 2";
        assertEquals(Cyberpunk8.army_communication_matrix(3, matrix), res);
    }

    @Test public void testRegres2() {
        int[][] matrix = {
                {1,9,2,3},
                {4,8,5,6},
                {0,7,1,2},
                {0,0,0,0}
        };
        String res = "1 0 3";
        assertEquals(Cyberpunk8.army_communication_matrix(4, matrix), res);
    }

    @Test public void testRegresStripRight() {
        int[][] matrix = {
                {1,9,2,3},
                {4,8,5,6},
                {0,7,1,2},
                {0,0,0,0}
        };
        assertEquals(Cyberpunk8.stripSum(4, "right", 0, 0, matrix), 11);
    }

    @Test public void testRegresStripLeft() {
        int[][] matrix = {
                {1,9,2,3},
                {4,8,5,6},
                {0,7,1,2},
                {0,0,0,0}
        };
        assertEquals(Cyberpunk8.stripSum(4, "left", 0, 0, matrix), 5);
    }

    @Test public void testRegresStripUp() {
        int[][] matrix = {
                {1,9,2,3},
                {4,8,5,6},
                {0,7,1,2},
                {0,0,0,0}
        };
        assertEquals(Cyberpunk8.stripSum(4, "up", 0, 0, matrix), 15);
    }

    @Test public void testRegresStripDown() {
        int[][] matrix = {
                {1,9,2,3},
                {4,8,5,6},
                {0,7,1,2},
                {0,0,0,0}
        };
        assertEquals(Cyberpunk8.stripSum(4, "down", 0, 0, matrix), 0);
    }

}