import java.util.*;

class Heap
{
    public int [] HeapArray; // хранит неотрицательные числа-ключи
    private int index = 0;

    public Heap() { HeapArray = null; }

    // Task 1 MakeHeap, Time - O(N logN), Space - O(1)
    public void MakeHeap(int[] a, int depth)
    {
        int size = (int) Math.pow(2, depth + 1) - 1;
        HeapArray = new int[size];
        Arrays.fill(HeapArray, -1);
        for (int elem : a) {
            Add(elem);
        }
    }

    // Task 2(subTask) GetMax, Time - , Space -
    public int GetMax()
    {
        // вернуть значение корня и перестроить кучу
        index--;
        return -1; // если куча пуста
    }

    // Task 2(subTask) Add, Time - O(logN), Space - O(1)
    public boolean Add(int key)
    {
        if (HeapArray[HeapArray.length - 1] > 0) return false;
        HeapArray[index] = key;
        traverseAncestor(index);
        index++;

        return false;
    }

    // Task 3 isProperHeap, Time - O(N), Space - O(1)
    boolean isProperHeap() {
        return traverseProper(0);
    }

    boolean traverseProper(int index) {
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

    void traverseAncestor(int index) {
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