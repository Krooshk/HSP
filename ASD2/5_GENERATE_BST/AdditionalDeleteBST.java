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
