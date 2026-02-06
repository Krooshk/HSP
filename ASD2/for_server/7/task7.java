import java.util.*;

class Heap
{
    public int [] HeapArray;

    public Heap() { HeapArray = null; }

    // Task 1 MakeHeap, Time O(N logN), Space O(1)
    public void MakeHeap(int[] a, int depth)
    {
        int size = (int) Math.pow(2, depth + 1) - 1;
        HeapArray = new int[size];
        for (int elem : a) {
            Add(elem);
        }
    }

    // Task 2 (subTask) GetMax, Time O(logN), Space O(1)
    public int GetMax()
    {
        if (HeapArray.length == 0 || HeapArray[0] == 0) return -1;
        int root = HeapArray[0];
        int index = find();

        if (index == -1) {
            index = HeapArray.length;
        }

        HeapArray[0] = HeapArray[index - 1];
        HeapArray[index - 1] = 0;
        traverseChilds(0);

        return root;
    }

    private void traverseChilds(int index) {
        if (index >= HeapArray.length) return;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int leftValue = leftIndex < HeapArray.length ? HeapArray[leftIndex] : -1;
        int rightValue = rightIndex < HeapArray.length ? HeapArray[rightIndex] : -1;

        if (HeapArray[index] >= leftValue && HeapArray[index] >= rightValue) {
            return;
        }

        if (leftValue < 0 && rightValue < 0) {
            return;
        }

        int nextIndex = rightValue >= leftValue ? rightIndex : leftIndex;
        int temp = HeapArray[index];
        HeapArray[index] = HeapArray[nextIndex];
        HeapArray[nextIndex] = temp;
        traverseChilds(nextIndex);
    }

    // Task 2 (subTask) Add, Time O(logN), Space O(1)
    public boolean Add(int key)
    {
        int index = find();
        if (index < 0) return false;
        HeapArray[index] = key;
        traverseAncestor(index);

        return true;
    }

    // Task 3 isProperHeap, Time O(N), Space O(1)
    public boolean isProperHeap() {
        return traverseProper(0);
    }

    private int find() {
        for (int i = 0; i < HeapArray.length; i++) {
            if (HeapArray[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public boolean traverseProper(int index) {
        if (index >= HeapArray.length) {
            return true;
        }

        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        boolean currLeft = leftIndex >= HeapArray.length || HeapArray[index] >= HeapArray[leftIndex];
        boolean currRight = rightIndex >= HeapArray.length || HeapArray[index] >= HeapArray[rightIndex];

        boolean deepCheckLeft = traverseProper(leftIndex);
        boolean deepCheckRight = traverseProper(rightIndex);

        return currLeft && currRight && deepCheckLeft && deepCheckRight;
    }

    private void traverseAncestor(int index) {
        if (index == 0) return;
        int indexAncestor = (index - 1) / 2;
        if (HeapArray[indexAncestor] < HeapArray[index]) {
            int temp = HeapArray[indexAncestor];
            HeapArray[indexAncestor] = HeapArray[index];
            HeapArray[index] = temp;
            traverseAncestor(indexAncestor);
        }
    }

}


