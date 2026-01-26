import java.util.*;

public class AlgorithmsDataStructures2
{
    // Task 1 GenerateBBSTArray, Time-O(N) Space-O(N)
    public static int[] GenerateBBSTArray(int[] a)
    {
        int[] copyArray = Arrays.copyOf(a, a.length);
        Arrays.sort(copyArray);
        int[] result = new int[a.length];
        helper(copyArray, result, 0);

        return result;
    }

    private static void helper(int[] workArray, int[] result, int index) {
        if (workArray.length == 0) return;
        int mid = workArray.length / 2;
        result[index] = workArray[mid];
        helper(Arrays.copyOfRange(workArray, 0, mid), result, 2 * index + 1);
        helper(Arrays.copyOfRange(workArray, mid + 1, workArray.length), result, 2 * index + 2);
    }
}

