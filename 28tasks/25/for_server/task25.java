import java.util.*;

public class Level1
{
    public static boolean TransformTransform(int[] A, int N){
        int[] first = tt(A, N);
        int[] second = tt(first, first.length);

        int sum = 0;

        for (int i = 0; i < second.length; i++) {
            sum += second[i];
        }

        return sum % 2 == 0;
    }

    public static int[] tt(int[] A, int N) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N - i; j++){
                int k = j + i;
                int[] copy = Arrays.copyOfRange(A, j, k + 1);
                int max = getMax(copy);
                list.add(max);
            }
        }

        int[] newArr = new int[list.size()];

        for (int i = 0; i < list.size(); i++){
            newArr[i] = list.get(i);
        }

        return newArr;
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }

        return max;
    }
}


