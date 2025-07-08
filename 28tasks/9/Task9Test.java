import org.junit.jupiter.api.RepeatedTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Task9Test {

    @Test public void testEmpty(){
        assertEquals(Task9.TheRabbitsFoot("", true), "");
    }

    @Test public void testEmpty2(){
        assertEquals(Task9.TheRabbitsFoot("", false), "");
    }

    @Test public void testRegres(){
        assertEquals(Task9.TheRabbitsFoot("отдай мою кроличью лапку", true), "омоюу толл дюиа акчп йрьк");
    }

    @Test public void testRegres2(){
        assertEquals(Task9.TheRabbitsFoot("омоюу толл дюиа акчп йрьк", false), "отдаймоюкроличьюлапку");
    }

}