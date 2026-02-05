import java.util.Arrays;

class HeapAdditional
{
    public int [] HeapArray; // хранит неотрицательные числа-ключи

    public HeapAdditional() { HeapArray = null; }

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

    // Task 2 (subTask) GetMax, Time - O(logN), Space - O(1)
    public int GetMax()
    {
        if (HeapArray[0] < 0) return -1;
        int root = HeapArray[0];
        int index = find();

        if (index == -1) {
            index = HeapArray.length;
        }

        HeapArray[0] = HeapArray[index - 1];
        HeapArray[index - 1] = -1;
        traverseChilds(0);

        return root;
    }

    void traverseChilds(int index) {
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

    // Task 2 (subTask) Add, Time - O(logN), Space - O(1)
    // Измененно для 6 задачи
    public boolean Add(int key)
    {
        if (HeapArray[HeapArray.length - 1] > 0) {
            int length = HeapArray.length;
            int[] newArr = Arrays.copyOf(HeapArray, length * 2);
            Arrays.fill(newArr, length, newArr.length, -1);
            HeapArray = newArr;
        }

        int index = find();
        HeapArray[index] = key;
        traverseAncestor(index);

        return true;
    }

    // Task 3 isProperHeap, Time - O(N), Space - O(1)
    boolean isProperHeap() {
        return traverseProper(0);
    }

    private int find() {
        for (int i = 0; i < HeapArray.length; i++) {
            if (HeapArray[i] == -1) {
                return i;
            }
        }

        return -1;
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

    // Task 4* getMax, Time - O(N), Space - O(1)
    // В худших случая будет время O(N) - если граница задана слишком низко и диапазон очень мал
    Integer getMax(int index, int min, int max) {
        if (index >= HeapArray.length || HeapArray[index] == -1 || HeapArray[index] < min) {
            return -1;
        }

        if (HeapArray[index] <= max) {
            return HeapArray[index];
        }

        int left = getMax(2 * index + 1, min, max );
        int right = getMax(2 * index + 2, min, max );

        return Math.max(left, right);
    }

    // Task 5* getMax, Time - O(N), Space - O(1)
    // В худших случая будет время O(N) - если граница задана слишком низко
    int getLessThen(int index, int border) {
        if (index >= HeapArray.length || HeapArray[index] == -1) {
            return -1;
        }

        if (HeapArray[index] < border) {
            return HeapArray[index];
        }

        int left = getLessThen(2 * index + 1, border );
        int right = getLessThen(2 * index + 2, border );

        return Math.max(left, right);
    }

    // Task 6* getMax, Time - O(N*logN), Space - O(1)
    // logN - доабвление, N - кол-во элементов в другой куче
    // Метод add здесь изменен, чтобы динамически увеличиваться при заполнении массива
    void addNewHeap(HeapAdditional addHeap) {
        int val = addHeap.GetMax();

        while (val > 0) {
            Add(val);
            val = addHeap.GetMax();
        }
    }

}
