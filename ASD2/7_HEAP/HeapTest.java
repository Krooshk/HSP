import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {
    @Test public void testRegres(){
        Heap heap = new Heap();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        heap.MakeHeap(arr, 2);

        int[] result = { 7, 4, 6, 1, 3, 2, 5 };
        assertArrayEquals(heap.HeapArray, result);
    }

    @Test public void testAddFullHeap(){
        Heap heap = new Heap();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        heap.MakeHeap(arr, 2);

        assertFalse(heap.Add(8));
    }

    @Test public void testProperHeap(){
        Heap heap = new Heap();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        heap.MakeHeap(arr, 2);

        assertTrue(heap.isProperHeap());
    }

    @Test public void testNotProperHeap(){
        Heap heap = new Heap();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        heap.MakeHeap(arr, 2);
        heap.HeapArray = arr;

        assertFalse(heap.isProperHeap());
    }

}