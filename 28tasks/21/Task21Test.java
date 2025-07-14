import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task21Test {

    @Test public void testRegres(){
        assertEquals(Task21.BiggerGreater("ая"), "яа");
    }

    @Test public void testRegres2() {
        assertEquals(Task21.BiggerGreater("fff"), "");
    }

    @Test public void testRegres3() {
        assertEquals(Task21.BiggerGreater("нклм"), "нкмл");
    }

    @Test public void testRegre4s() {
        assertEquals(Task21.BiggerGreater("вибк"), "викб");
    }

    @Test public void testRegres5() {
        assertEquals(Task21.BiggerGreater("вкиб"), "ибвк");
    }

}


