import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmsDataStructures2Test {
    @Test public void testEmpty(){
        assertArrayEquals(AlgorithmsDataStructures2.GenerateBBSTArray(new int[0]), new int[0]);
    }

    @Test public void testBase1(){
        int[] array = { 1 };

        assertArrayEquals(AlgorithmsDataStructures2.GenerateBBSTArray(array), array);
    }

    @Test public void testBase2(){
        int[] array = { 1, 3, 2 };
        int[] result = { 2, 1, 3};

        assertArrayEquals(AlgorithmsDataStructures2.GenerateBBSTArray(array), result);
    }

    @Test public void testBase3(){
        int[] array = { 1, 3, 2, 4, 7, 5, 6 };
        int[] result = { 4, 2, 6, 1, 3, 5, 7 };

        assertArrayEquals(AlgorithmsDataStructures2.GenerateBBSTArray(array), result);
    }

    @Test public void testBase4(){
        int[] array = { 1, 3, 2, 4, 7, 8, 9, 5, 6, 15, 11, 10, 12, 14, 13 };
        int[] result = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15 };


        assertArrayEquals(AlgorithmsDataStructures2.GenerateBBSTArray(array), result);
    }

}