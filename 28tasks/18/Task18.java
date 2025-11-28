import java.util.*;

public class Task18
{
    public static boolean MisterRobot(int N, int [] data) {
        int[] copy = Arrays.copyOf(data, N);

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < N - 1 - i; j+=2) {
                if (j == (N - i - 2)) {
                    j = N - i - 3;
                }

                int[] arr = swap(Arrays.copyOfRange(copy, j, j + 3));
                copy[j] = arr[0];
                copy[j + 1] = arr[1];
                copy[j + 2] = arr[2];
            }
        }

        return compare(copy);
    }

    public static boolean compare(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);

        for (int i = 0; i < arr.length; i++){
            boolean isNotEqualElems = arr[i] != copy[i];
            if (isNotEqualElems) {
                return false;
            }
        }

        return true;
    }

    public static int[] swap(int[] arr) {
        int amountSwap = countSwap(arr);

        for (int i = 0; i < countSwap(arr); i++) {
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = temp;
        }

        return arr;
    }

    public static int countSwap(int[] arr) {
        if (arr[2] >= arr[0] && arr[2] >= arr[1]) {
            return 0;
        }

        if (arr[0] >= arr[1] && arr[0] >= arr[2]) {
            return 1;
        }

        return 2;
    }
}

