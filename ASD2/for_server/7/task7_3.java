import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {
    @Test public void testGenerateEmpty(){
        Heap heap = new Heap();
        int[] arr = { };
        heap.MakeHeap(arr, 0);

        int[] result = { -1 };
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

    @Test public void getMaxProperlyOrder(){
        Heap heap = new Heap();
        int[] arr = { 11, 9, 4, 7, 8, 3, 1, 2, 5, 6 };
        heap.MakeHeap(arr, 3);

        int[] result = { 9, 8, 4, 7, 6, 3, 1, 2, 5, -1, -1, -1, -1, -1, -1 };
        assertEquals(heap.GetMax(), 11);
        assertArrayEquals(heap.HeapArray, result);
    }

}

class HeapAdditionalTest {
    @Test public void getMaxRegres(){
        HeapAdditional heapAdditional = new HeapAdditional();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        heapAdditional.MakeHeap(arr, 2);

        assertEquals(heapAdditional.getMax(0,  3, 4), 4);
    }

    @Test public void getMaxRegres2(){
        HeapAdditional heapAdditional = new HeapAdditional();
        int[] arr = { 1, 3, 5, 7, 9, 11, 13 };
        heapAdditional.MakeHeap(arr, 2);

        assertEquals(heapAdditional.getMax(0,  0, 10), 9);
    }

    @Test public void getMaxNotSuchNumber(){
        HeapAdditional heapAdditional = new HeapAdditional();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        heapAdditional.MakeHeap(arr, 2);

        assertEquals(heapAdditional.getMax(0, 9, 8), -1);
    }

    @Test public void getEmpty(){
        HeapAdditional heapAdditional = new HeapAdditional();
        int[] arr = { };
        heapAdditional.MakeHeap(arr, 0);

        assertEquals(heapAdditional.getMax(0, 9, 8), -1);
    }

    @Test public void getLessThen(){
        HeapAdditional heapAdditional = new HeapAdditional();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        heapAdditional.MakeHeap(arr, 2);

        assertEquals(heapAdditional.getLessThen(0,  6), 5);
    }

    @Test public void getLessThen2(){
        HeapAdditional heapAdditional = new HeapAdditional();
        int[] arr = { 1, 3, 5, 7, 9, 11, 13 };
        heapAdditional.MakeHeap(arr, 2);

        assertEquals(heapAdditional.getLessThen(0,  100), 13);
    }

    @Test public void getLessThen2NotSuchNumber(){
        HeapAdditional heapAdditional = new HeapAdditional();
        int[] arr = {  3, 4, 5, 6, 7 };
        heapAdditional.MakeHeap(arr, 2);

        assertEquals(heapAdditional.getLessThen(0,  2), -1);
    }

    @Test public void getLessThenEmpty(){
        HeapAdditional heapAdditional = new HeapAdditional();
        int[] arr = { };
        heapAdditional.MakeHeap(arr, 0);

        assertEquals(heapAdditional.getLessThen(0, 100), -1);
    }

    @Test public void addAnotherHeap(){
        HeapAdditional heapAdditional = new HeapAdditional();
        int[] arr = { 1, 3, 5, 7, 9, 11, 13 };
        heapAdditional.MakeHeap(arr, 2);
        HeapAdditional heapAdditional2 = new HeapAdditional();
        int[] arr2 = { 20, 21, 22, 23, 24 };
        heapAdditional2.MakeHeap(arr2, 2);

        heapAdditional.addNewHeap(heapAdditional2);

        assertTrue(heapAdditional.isProperHeap());
    }

    @Test public void addAnotherHeapEqual(){
        HeapAdditional heapAdditional = new HeapAdditional();
        int[] arr = { 1, 3, 5, 7, 9, 11, 13 };
        heapAdditional.MakeHeap(arr, 2);
        HeapAdditional heapAdditional2 = new HeapAdditional();
        int[] arr2 = { 1, 3, 5, 7, 9, 11, 13 };
        heapAdditional2.MakeHeap(arr2, 2);

        heapAdditional.addNewHeap(heapAdditional2);

        assertTrue(heapAdditional.isProperHeap());
    }

    @Test public void addAnotherHeapEmpty(){
        HeapAdditional heapAdditional = new HeapAdditional();
        int[] arr = { 1, 3, 5, 7, 9, 11, 13 };
        heapAdditional.MakeHeap(arr, 2);
        HeapAdditional heapAdditional2 = new HeapAdditional();
        int[] arr2 = {  };
        heapAdditional2.MakeHeap(arr2, 0);

        heapAdditional.addNewHeap(heapAdditional2);

        assertTrue(heapAdditional.isProperHeap());
    }
}