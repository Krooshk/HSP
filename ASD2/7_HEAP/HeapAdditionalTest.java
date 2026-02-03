import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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