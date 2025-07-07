import org.junit.jupiter.api.RepeatedTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Task8Test {
    @Test public void testRegres(){
        int[] arr = new int[]{ 100, -50, 10, -25, 90, -35, 90 };

        assertEquals(Task8.SumOfThe(arr.length, arr), 90);
    }

    @Test public void testRegres2(){
        int[] arr = new int[]{ 10, -25, -45, -35, 5 };

        assertEquals(Task8.SumOfThe(arr.length, arr), -45);
    }

}