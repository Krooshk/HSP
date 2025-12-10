import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task13Test {

    // Работает только с 8, и 16-ным форматами, последний параметр является флагом, что число восьмеричное
    @Test public void testEmpty(){
        int[] nums = new int[0];
        int[] result = new int[0];
        assertArrayEquals(Task13.UFO(nums.length, nums, false), result);
    }

    @Test public void testRegres(){
        int[] nums = new int[]{ 1234,1777 };
        int[] result = new int[]{ 4660, 6007 };
        assertArrayEquals(Task13.UFO(nums.length, nums, false), result);
    }

    @Test public void testRegres1(){
        int[] nums = new int[]{ 1234,1777 };
        int[] result = new int[]{ 668, 1023 };
        assertArrayEquals(Task13.UFO(nums.length, nums, true), result);
    }

}