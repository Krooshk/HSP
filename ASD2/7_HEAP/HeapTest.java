import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {
    @Test public void testGenerateEmpty(){
        Heap heap = new Heap();
        int[] arr = { };
        heap.MakeHeap(arr, 0);

        int[] result = { 0 };
        assertArrayEquals(heap.HeapArray, result);
    }

    @Test public void testGenerateOne(){
        Heap heap = new Heap();
        int[] arr = { 2 };
        heap.MakeHeap(arr, 0);

        int[] result = { 2 };
        assertArrayEquals(heap.HeapArray, result);
    }

    @Test public void testGenerateRegres(){
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

    @Test public void testAddPositive(){
        Heap heap = new Heap();
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        heap.MakeHeap(arr, 2);

        assertTrue(heap.Add(8));
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

    @Test public void getMax(){
        Heap heap = new Heap();
        int[] arr = { 11, 9, 4, 7, 8, 3, 1, 2, 5, 6 };
        heap.MakeHeap(arr, 3);

        assertEquals(heap.GetMax(), 11);
    }

    @Test public void getMaxEmptyHeap(){
        Heap heap = new Heap();
        int[] arr = { 11,};
        heap.MakeHeap(arr, 0);

        heap.GetMax();
        assertEquals(heap.GetMax(), -1);
    }

    @Test public void getMaxCheckArray(){
        Heap heap = new Heap();
        int[] arr = { 11,};
        heap.MakeHeap(arr, 0);

        heap.GetMax();
        int[] result = { 0 };
        assertArrayEquals(heap.HeapArray, result);
    }

    @Test public void getMaxProperlyOrder(){
        Heap heap = new Heap();
        int[] arr = { 11, 9, 4, 7, 8, 3, 1, 2, 5, 6 };
        heap.MakeHeap(arr, 3);

        int[] result = { 9, 8, 4, 7, 6, 3, 1, 2, 5, 0, 0, 0, 0, 0, 0 };
        assertEquals(heap.GetMax(), 11);
        assertArrayEquals(heap.HeapArray, result);
    }

    @Test public void testGetMaxRegres(){
        Heap heap = new Heap();
        int[] arr = {  };
        heap.MakeHeap(arr, 3);
        int[] array = { 110, 90, 40, 70, 80, 31, 11, 20, 50, 60, 65, 30, 29, 10, 9 };
        heap.HeapArray = array;
        heap.GetMax();

        int[] result = { 90, 80, 40, 70, 65, 31, 11, 20, 50, 60, 9, 30, 29, 10, 0 };
        assertArrayEquals(heap.HeapArray, result);
    }

    @Test public void arrayFillsZeroForInt(){
        Heap heap = new Heap();
        int[] arr = {  };
        heap.MakeHeap(arr, 1);

        int[] result = { 0, 0, 0 };
        assertArrayEquals(heap.HeapArray, result);
    }

}