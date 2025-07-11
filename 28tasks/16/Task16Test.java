import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task16Test {

    @Test public void testRegres(){
        int[] arr = new int[] {400, 350, 300, 250, 200, 150, 100 };
        assertEquals(Task16.MaximumDiscount(7, arr), 450);
    }

    @Test public void testRegres2(){
        int[] arr = new int[] { 300, 200 };
        assertEquals(Task16.MaximumDiscount(2, arr), 0);
    }

    @Test public void testEmpty(){
        int[] arr = new int[] { };
        assertEquals(Task16.MaximumDiscount(0, arr), 0);
    }

}