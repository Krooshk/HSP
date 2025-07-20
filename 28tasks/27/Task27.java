import java.util.*;

public class Task27
{
    static public boolean Football(int F[], int N){
        int[] copyOrder = Arrays.copyOf(F, N);
        int[] copySwap = Arrays.copyOf(F, N);
        Integer start = null;
        Integer finish = null;

        for (int i = 0; i < N - 1; i++){
            if (F[i] > F[i+1] && start == null){
                start = i;
            }

            if (start != null && F[i] < F[i+1]) {
                finish = i;
            }
        }

        if (finish == null) {
            finish = N - 1;
        }

        int length = finish - start + 1;

        if (length >= 2) {
            for (int i = 0; i < length / 2; i++){
                int temp = copyOrder[finish  - i];
                copyOrder[finish - i] = copyOrder[start + i];
                copyOrder[start + i] = temp;
            }

            boolean isRightOrder = check(copyOrder);
            if (isRightOrder) return true;
        }

        for (int i = N - 1; i > 0; i--) {
            if (F[i] < F[i - 1]){
                finish = i;
                break;
            }
        }

        int temp = copySwap[start];
        copySwap[start] = copySwap[finish];
        copySwap[finish] = temp;

        return  check(copySwap);
    }

    static public boolean check(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] > arr[i+1]){
                return false;
            }
        }

        return true;
    }



}



