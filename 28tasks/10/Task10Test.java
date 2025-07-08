import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task10Test {

    @Test public void testEmpty(){
        assertEquals(Task10.PrintingCosts(""), 0);
    }

    @Test public void testRegres(){
        assertEquals(Task10.PrintingCosts("                      "), 0);
    }

    @Test public void testRegres1(){
        assertEquals(Task10.PrintingCosts("    @           F     L    "), 68);
    }

    @Test public void testRegres2(){
        assertEquals(Task10.PrintingCosts("G"), 25);
    }

    @Test public void testRegres3(){
        assertEquals(Task10.PrintingCosts("ЮЮЮЮЮЮЮЮЮЮ"), 230);
    }

}