import org.junit.jupiter.api.RepeatedTest;
import org.junit.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Task4Test {

    @RepeatedTest(10)
     public void testRandom() {
        Random rand = new Random();
        int size = rand.nextInt(127) + 1;
        if (size % 2 == 0) {
            size += 1;
        }
        int right = size - 1;

        int[] inputArr = new int[size];
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = inputArr.length - i;
        }

        int[] arrRequired = new int[size];
        int center = arrRequired.length / 2;

        for (int i = 0; i < center; i++) {
            arrRequired[i] = i + 1;
        }
        arrRequired[center] = inputArr.length;
        for (int i = center + 1; i < size; i++) {
            arrRequired[i] = right;
            right--;
        }

        assertArrayEquals(Task4.MadMax(size, inputArr), arrRequired);
    }

    @Test public void testMax() {
        int[] inputArr = new int[127];
        int right = 126;
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = inputArr.length - i;
        }

        int[] arrRequired = new int[127];
        int center = arrRequired.length / 2;

        for (int i = 0; i < center; i++) {
            arrRequired[i] = i + 1;
        }

        arrRequired[center] = inputArr.length;
        for (int i = center + 1; i < 127; i++) {
            arrRequired[i] = right;
            right--;
        }

        assertArrayEquals(Task4.MadMax(127, inputArr), arrRequired);
    }

    @Test public void testMin() {
        int[] inputArr = new int[]{ 3 };
        int[] arrRequired = new int[]{ 3 };

        assertArrayEquals(Task4.MadMax(1, inputArr), arrRequired);
    }

    @Test public void testRegres() {
        int[] inputArr = new int[]{ 1, 2, 3, 4, 5, 6, 7 };
        int[] arrRequired = new int[]{ 1, 2, 3, 7, 6, 5, 4 };

        assertArrayEquals(Task4.MadMax(7, inputArr), arrRequired);
    }
}