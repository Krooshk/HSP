import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Task28Test {

    @Test public void testRegres() {
        assertEquals(Task28.Keymaker(1), "1");
    }

    @Test public void testRegres2() {
        assertEquals(Task28.Keymaker(2), "10");
    }

    @Test public void testRegres3() {
        assertEquals(Task28.Keymaker(3), "100");
    }

    @Test public void testRegres4() {
        assertEquals(Task28.Keymaker(4), "1001");
    }

    @Test public void testRegres5() {
        assertEquals(Task28.Keymaker(5), "10010");
    }

    @Test public void testRegres6() {
        assertEquals(Task28.Keymaker(6), "100100");
    }

    @Test public void testRegres7() {
        assertEquals(Task28.Keymaker(7), "1001000");
    }

    @Test public void testRegres8() {
        assertEquals(Task28.Keymaker(8), "10010000");
    }

    @Test public void testRegres9() {
        assertEquals(Task28.Keymaker(9), "100100001");
    }

    @Test public void testRegres16() {
        assertEquals(Task28.Keymaker(16), "1001000010000001");
    }

    @Test public void testRegres25() {
        assertEquals(Task28.Keymaker(25), "1001000010000001000000001");
    }

    @Test public void testRegres36() {
        assertEquals(Task28.Keymaker(36), "100100001000000100000000100000000001");
    }

}




