import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task17Test {

    @Test public void testRegres1(){
        assertEquals(Task17.LineAnalysis("*..*..*..*..*..*..*"), true);
    }

    @Test public void testRegres2(){
        assertEquals(Task17.LineAnalysis("*..*...*..*..*..*..*"), false);
    }

    @Test public void testRegres3(){
        assertEquals(Task17.LineAnalysis("*..*..*..*..*..**..*"), false);
    }

    @Test public void testRegres4(){
        assertEquals(Task17.LineAnalysis("*"), true);
    }

    @Test public void testRegres5(){
        assertEquals(Task17.LineAnalysis("***"), true);
    }

    @Test public void testRegres6(){
        assertEquals(Task17.LineAnalysis("*.......*.......*"), true);
    }

    @Test public void testRegres7(){
        assertEquals(Task17.LineAnalysis("**"), true);
    }

    @Test public void testRegres8(){
        assertEquals(Task17.LineAnalysis("*.*"), true);
    }

    @Test public void testEmpty(){
        assertEquals(Task17.LineAnalysis(""), false);
    }

}