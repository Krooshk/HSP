import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task22Test {

    @Test public void testRegres() {
        assertEquals(Task22.SherlockValidString("xyz"), true);
    }

    @Test public void testRegres2() {
        assertEquals(Task22.SherlockValidString("xyzaa"), true);
    }

    @Test public void testRegres3() {
        assertEquals(Task22.SherlockValidString("xxyyz"), true);
    }

    @Test public void testRegres4() {
        assertEquals(Task22.SherlockValidString("xyzzz"), false);
    }

    @Test public void testRegres5() {
        assertEquals(Task22.SherlockValidString("xxyyza"), false);
    }

    @Test public void testRegres6() {
        assertEquals(Task22.SherlockValidString("xxyyzabc"), false);
    }

}


