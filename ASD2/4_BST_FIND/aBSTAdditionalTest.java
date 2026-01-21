import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class aBSTAdditionalTest {
    @Test public void testLCA_Root(){
        aBSTAdditional abst = new aBSTAdditional(3);
        int[] keys = { 50, 75, 84, 92, 62, 55, 65, 80, 25, 10, 5, 37, 31, 43, 11 };

        for (int key: keys) {
            abst.AddKey(key);
        }

        assertEquals(abst.getLCA(7, 14),  0);
    }

    @Test public void testLCA_Regress(){
        aBSTAdditional abst = new aBSTAdditional(3);
        int[] keys = { 50, 75, 84, 92, 62, 55, 65, 80, 25, 10, 5, 37, 31, 43, 11 };

        for (int key: keys) {
            abst.AddKey(key);
        }

        assertEquals(abst.getLCA(11, 13),  2);
    }

    @Test public void testLCA_Neighborhood(){
        aBSTAdditional abst = new aBSTAdditional(3);
        int[] keys = { 50, 75, 84, 92, 62, 55, 65, 80, 25, 10, 5, 37, 31, 43, 11 };

        for (int key: keys) {
            abst.AddKey(key);
        }

        assertEquals(abst.getLCA(9, 10),  4);
    }

    @Test public void testLCA_Diff_Level(){
        aBSTAdditional abst = new aBSTAdditional(3);
        int[] keys = { 50, 75, 84, 92, 62, 55, 65, 80, 25, 10, 5, 37, 31, 43, 11 };

        for (int key: keys) {
            abst.AddKey(key);
        }

        assertEquals(abst.getLCA(11, 6),  2);
    }

    @Test public void testLCA_Nothing(){
        aBSTAdditional abst = new aBSTAdditional(3);
        int[] keys = { 50, 75, 84, 92, 62, 55, 65, 80, 25, 10, 5, 37, 31, 43, 11 };

        for (int key: keys) {
            abst.AddKey(key);
        }

        assertTrue(abst.getLCA(0, 14) < 0);
    }

    @Test public void testLCA_NULL(){
        aBSTAdditional abst = new aBSTAdditional(3);
        int[] keys = { 50, 75, 84, 92, 62, 55, 65, 80, 25, 10, 5, 37, 31, 43, 11 };

        for (int key: keys) {
            abst.AddKey(key);
        }

        assertEquals(abst.getLCA(null, null), null);
    }

    @Test public void testLCA_NULL_1(){
        aBSTAdditional abst = new aBSTAdditional(3);
        int[] keys = { 50, 75, 84, 92, 62, 55, 65, 80, 25, 10, 5, 37, 31, 43, 11 };

        for (int key: keys) {
            abst.AddKey(key);
        }

        assertEquals(abst.getLCA(null, 14) , null);
    }

    @Test public void testLCA_NULL_2(){
        aBSTAdditional abst = new aBSTAdditional(3);
        int[] keys = { 50, 75, 84, 92, 62, 55, 65, 80, 25, 10, 5, 37, 31, 43, 11 };

        for (int key: keys) {
            abst.AddKey(key);
        }

        assertEquals(abst.getLCA(0, null), null);
    }
}