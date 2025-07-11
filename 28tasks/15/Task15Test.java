import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task15Test {

    @Test public void testEmty(){
        assertEquals(Task15.TankRush(0, 0, "", 0, 0, ""), false);
    }

    @Test public void testEmty2(){
        assertEquals(Task15.TankRush(3, 4, "1234 2345 0987", 0, 0, ""), false);
    }

    @Test public void testRegres(){
        assertEquals(Task15.TankRush(3, 4, "1234 2345 0987", 1, 1, "1"), true);
    }

    @Test public void testRegres2(){
        assertEquals(Task15.TankRush(3, 4, "1234 2345 0987", 2, 2, "34 98"), true);
    }

    @Test public void testRegres3(){
        assertEquals(Task15.TankRush(3, 4, "1234 2345 0987", 3, 4, "1234 2345 0987"), true);
    }

    @Test public void testRegres4(){
        assertEquals(Task15.TankRush(3, 4, "1234 2345 0987", 4, 4, "1234 2345 0987 0987"), false);
    }

}