import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task11Test {

    @Test public void testRegres1(){
        assertEquals(Task11.BigMinus("1", "321"), "320");
    }

    @Test public void testRegres2(){
        assertEquals(Task11.BigMinus("321", "1"), "320");
    }

    @Test public void testRegres(){
        assertEquals(Task11.BigMinus("10", "1"), "9");
    }

    @Test public void testRegres3(){
        assertEquals(Task11.BigMinus("10000000000000000", "1"), "9999999999999999");
    }

    @Test public void testRegres4(){
        assertEquals(Task11.BigMinus("10000000000000000", "1"), "9999999999999999");
    }

    @Test public void testRegres5(){
        assertEquals(Task11.BigMinus("671", "236"), "435");
    }

}