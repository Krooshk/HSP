import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task23Test {

    @Test public void testRegres0() {
        String[] arr = new String[]{ ".+..", "..+.", ".+.." };
        String[] result = new String[]{ ".+..", "..+.", ".+.." };
        assertArrayEquals(Task23.TreeOfLife(3,4, 0, arr), result);
    }

    @Test public void testRegres1() {
        String[] arr = new String[]{ ".+..", "..+.", ".+.." };
        String[] result = new String[]{ "++++", "++++", "++++" };
        assertArrayEquals(Task23.TreeOfLife(3,4, 1, arr), result);
    }

    @Test public void testRegres2() {
        String[] arr = new String[]{ ".+..", "..+.", ".+.." };
        String[] result = new String[]{ "...+", "+...", "...+" };
        assertArrayEquals(Task23.TreeOfLife(3,4, 2, arr), result);
    }

    @Test public void testRegres3() {
        String[] arr = new String[]{ ".+..", "..+.", ".+.." };
        String[] result = new String[]{ "++++", "++++", "++++" };
        assertArrayEquals(Task23.TreeOfLife(3,4, 3, arr), result);
    }

    @Test public void testRegres4() {
        String[] arr = new String[]{ ".+..", "..+.", ".+.." };
        String[] result = new String[]{ ".+..", "..+.", ".+.." };
        assertArrayEquals(Task23.TreeOfLife(3,4, 4, arr), result);
    }

    @Test public void testRegres5() {
        String[] arr = new String[]{ ".+..", "..+.", ".+.." };
        String[] result = new String[]{ "++++", "++++", "++++" };
        assertArrayEquals(Task23.TreeOfLife(3,4, 5, arr), result);
    }

    @Test public void testRegres6() {
        String[] arr = new String[]{ ".+..", "..+.", ".+.." };
        String[] result = new String[]{ "...+", "+...", "...+" };
        assertArrayEquals(Task23.TreeOfLife(3,4, 6, arr), result);
    }

    @Test public void testRegres7() {
        String[] arr = new String[]{ ".+..", "..+.", ".+.." };
        String[] result = new String[]{ "++++", "++++", "++++" };
        assertArrayEquals(Task23.TreeOfLife(3,4, 7, arr), result);
    }

    @Test public void testRegres8() {
        String[] arr = new String[]{ ".+..", "..+.", ".+.." };
        String[] result = new String[]{ ".+..", "..+.", ".+.." };
        assertArrayEquals(Task23.TreeOfLife(3,4, 8, arr), result);
    }

    @Test public void testRegres9() {
        String[] arr = new String[]{ ".+..", "..+.", ".+.." };
        String[] result = new String[]{ "++++", "++++", "++++" };
        assertArrayEquals(Task23.TreeOfLife(3,4, 9, arr), result);
    }

    @Test public void testRegres10() {
        String[] arr = new String[]{ ".+..", "..+.", ".+.." };
        String[] result = new String[]{ "...+", "+...", "...+" };
        assertArrayEquals(Task23.TreeOfLife(3,4, 10, arr), result);
    }

}




