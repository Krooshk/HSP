import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task18Test {

    @Test public void testRegres(){
        int[] arr = new int[]{ 1, 3, 4, 5, 6, 2, 7 };
        assertEquals(Task18.MisterRobot(7, arr), true);
    }

    @Test public void testRegres2(){
        int[] arr = new int[]{ 1, 2, 3, 4, 5, 6, 7 };
        assertEquals(Task18.MisterRobot(7, arr), true);
    }

    @Test public void testRegres3(){
        int[] arr = new int[]{ 1, 3, 2, 4, 5, 6, 7 };
        assertEquals(Task18.MisterRobot(7, arr), false);
    }

    @Test public void testRegres4(){
        int[] arr = new int[]{ 1, 2, 3, 4, 5, 6, 7 };
        assertEquals(Task18.MisterRobot(7, arr), true);
    }

}


