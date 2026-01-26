import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgorithmsDataStructures2Additional {
    // Задание 2
    // Видно, что разница при запуске отличается не просто в разы, а на порядки, в данном случае работа с массивом происходит на два порядка быстрее, чем обычный способ с указателями.
    // Я думаю это связано с простой арифметикой и быстротой доступа к элементам массива.

//    Ниже листинги из запуска метода поиска ключа в предыдущих заданиях.
//    @Test public void testSpeed(){
//        aBST abst = new aBST(3);
//        int[] keys = { 50, 75, 84, 92, 62, 55, 65, 80, 25, 10, 5, 37, 31, 43, 11 };
//
//        for (int key: keys) {
//            abst.AddKey(key);
//        }
//        long startTime = System.nanoTime();
//        abst.FindKeyIndex(92);
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        System.out.println("Время выполнения: " + duration + " мс"); // 1122 1743 1532 ~ 1465 нс
//    }

//    @Test public void testSpeedFind(){
//        BSTNode<Integer> root = new BSTNode<Integer>(50, 50, null);
//        BSTNode<Integer> two1 = new BSTNode<Integer>(25, 25, root);
//        BSTNode<Integer> two2 = new BSTNode<Integer>(75, 75, root);
//        BSTNode<Integer> three1 = new BSTNode<Integer>(10, 10, two1);
//        BSTNode<Integer> three2 = new BSTNode<Integer>(37, 37, two1);
//        BSTNode<Integer> three3 = new BSTNode<Integer>(62, 62, two2);
//        BSTNode<Integer> three4 = new BSTNode<Integer>(84, 84, two2);
//        BSTNode<Integer> four1 = new BSTNode<Integer>(5, 5, three1);
//        BSTNode<Integer> four2 = new BSTNode<Integer>(11, 11, three1);
//        BSTNode<Integer> four3 = new BSTNode<Integer>(31, 31, three2);
//        BSTNode<Integer> four4 = new BSTNode<Integer>(43, 43, three2);
//        BSTNode<Integer> four5 = new BSTNode<Integer>(55, 55, three3);
//        BSTNode<Integer> four6 = new BSTNode<Integer>(65, 65, three3);
//        BSTNode<Integer> four7 = new BSTNode<Integer>(80, 80, three4);
//        BSTNode<Integer> four8 = new BSTNode<Integer>(92, 92, three4);
//        root.LeftChild = two1;
//        root.RightChild = two2;
//        two1.LeftChild = three1;
//        two1.RightChild = three2;
//        two2.LeftChild = three3;
//        two2.RightChild = three4;
//        three1.LeftChild = four1;
//        three1.RightChild = four2;
//        three2.LeftChild = four3;
//        three2.RightChild = four4;
//        three3.LeftChild = four5;
//        three3.RightChild = four6;
//        three4.LeftChild = four7;
//        three4.RightChild = four8;
//        BST<Integer> bst = new BST<>(root);
//
//        long startTime = System.nanoTime();
//        bst.FindNodeByKey(92);
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        System.out.println("Время выполнения: " + duration + " нс"); // 265576 152511 139366  ~ 185817 нс
//    }

    // Задание 4*
    // Неотсортированный массив никак не отсортировать за О(1), сортировка бинарного дерева за О(1) возможно только,
    // если на вход подается подготовленный массив.
}

import java.util.Arrays;

public class AdditionalDeleteBST {
    Integer [] bst;

    public AdditionalDeleteBST(int[] a) {
        bst = GenerateBBSTArray(a);
    }

    Integer[] GenerateBBSTArray(int[] a)
    {
        int[] copyArray = Arrays.copyOf(a, a.length);
        Arrays.sort(copyArray);
        Integer[] result = new Integer[a.length];
        helper(copyArray, result, 0);

        return result ;
    }

    private static void helper(int[] workArray, Integer[] result, int index) {
        if (workArray.length == 0) return;
        int mid = workArray.length / 2;
        result[index] = workArray[mid];
        helper(Arrays.copyOfRange(workArray, 0, mid), result, 2 * index + 1);
        helper(Arrays.copyOfRange(workArray, mid + 1, workArray.length), result, 2 * index + 2);
    }

    public Integer FindKeyIndex(int key)
    {
        int index = 0;

        while (index < bst.length && bst[index] != null) {
            if (key == bst[index]) {
                return index;
            }

            if (key < bst[index]) {
                index = index * 2 + 1;
                continue;
            }

            if (key > bst[index]) {
                index = index * 2 + 2;
            }
        }

        if (index >= bst.length)  return null;

        return index * -1;
    }

    int getMin(int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;

        if (leftIndex >= bst.length) {
            return index;
        }
        if (leftIndex < bst.length && bst[leftIndex] != null) {
            return getMin(leftIndex);
        }
        if (bst[index] != null && (rightIndex >= bst.length || bst[rightIndex] == null)) {
            return index;
        }

        return -1 * index;
    }

    // Задание 3* delete Time - (O(log N)) , Space - O(1)
    boolean delete(int key) {
        Integer index = FindKeyIndex(key);
        if (index == null) return false;
        int rightIndex = index * 2 + 2;
        if (rightIndex >= bst.length) {
            bst[index] = null;
            return true;
        }
        int minIndex = getMin(rightIndex);
        if (minIndex >= 0) {
            bst[index] = bst[minIndex];
            bst[minIndex] = null;
            return true;
        }

        bst[index] = bst[-1 * minIndex];
        traverseChildren(-1 * minIndex, true);
        return true;
    }

    void traverseChildren(int index, boolean isRight) {
        int newIndex = isRight ? (index + 2) / 2 - 2 : (index + 1) / 2 - 1;
        if (newIndex >= bst.length) return;
        bst[newIndex] = bst[index];
        bst[index] = null;

        traverseChildren((index + 1) / 2 - 1, false);
        traverseChildren((index + 2) / 2 - 2, true);
    }
}




