import java.util.*;

public class Task4
{
    public static int [] MadMax(int N, int [] Tele) {
        int [] arr = new int[N];
        int[] copyTele = Arrays.copyOf(Tele, Tele.length);
        int last = 0;
        Arrays.sort(copyTele);

        for (int i = 0; i < N / 2; i++) {
            arr[i] = copyTele[i];
            last = i;
        }
        last += 1;

        arr[center] = copyTele[N - 1];
        for (int i = N - 1; i > center; i--) {
            arr[i] = copyTele[last];
            last++;
        }

        return arr;
    }
}


