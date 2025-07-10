import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task14Test {

    @Test public void testEmpty(){
        int [][] arr = new int[][]{{}};
        assertEquals(Task14.Unmanned(0, 0, arr), 0);
    }

    @Test public void testEmpty2(){
        int [][] arr = new int[][]{{}};
        assertEquals(Task14.Unmanned(10, 0, arr), 10);
    }

    @Test public void testRegres(){
        int [][] arr = new int[][]{ {3,5,5}, {5,2,2} };
        assertEquals(Task14.Unmanned(10, 2, arr), 12);
    }

    @Test public void testRegres1(){
        int [][] arr = new int[][]{ {10,20,20}, };
        assertEquals(Task14.Unmanned(10, 1, arr), 10);
    }

}