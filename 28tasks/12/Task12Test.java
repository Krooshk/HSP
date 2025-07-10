import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task12Test {

    @Test public void testEmpty(){
        int [] votes = new int[0];
        assertEquals(Task12.MassVote(0, votes), "no winner");
    }

    @Test public void testRegres1(){
        int [] votes = new int[]{ 10, 15, 10 };
        assertEquals(Task12.MassVote(votes.length, votes), "minority winner 2");
    }

    @Test public void testRegres2(){
        int [] votes = new int[]{ 111, 111, 110, 110 };
        assertEquals(Task12.MassVote(votes.length, votes), "no winner");
    }

    @Test public void testRegres3(){
        int [] votes = new int[]{ 60, 10, 10, 15, 5 };
        assertEquals(Task12.MassVote(votes.length, votes), "majority winner 1");
    }

}