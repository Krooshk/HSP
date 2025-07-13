import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task19Test {

    @Test public void testRegres(){
        String[] arr = new String[]{ "платье1 5", "сумка32 2",  "платье1 1",  "сумка23 2", "сумка128 4" };
        String[] result = new String[] {"платье1 6", "сумка128 4", "сумка23 2", "сумка32 2" };
        assertArrayEquals(Task19.ShopOLAP(5, arr), result);
    }

    @Test public void testRegres2(){
        String[] arr = new String[]{ "й 34", "ц 234",  "к 78",  "н 2", "г 4" };
        String[] result = new String[] {"ц 234", "к 78", "й 34", "г 4", "н 2" };
        assertArrayEquals(Task19.ShopOLAP(5, arr), result);
    }

    @Test public void testRegres3(){
        String[] arr = new String[]{ "a 4", "c 4",  "b 4",  "e 4", "d 4" };
        String[] result = new String[] { "a 4", "b 4",  "c 4",  "d 4", "e 4"};
        assertArrayEquals(Task19.ShopOLAP(5, arr), result);
    }

    @Test public void testRegresSwap(){
        assertEquals(Task19.swap("й 34", "ц 234"), true);
    }

    @Test public void testRegresSwap2(){
        assertEquals(Task19.swap("н 2", "г 4"), true);
    }

}


