import java.util.*;

public class Task16
{
    public static int MaximumDiscount(int N, int [] price) {
        int[] copy = Arrays.copyOf(price, N);
        Arrays.sort(copy);
        int result = 0;

        for (int i = N - 3; i >= 0; i-= 3) {
            result += copy[i];
        }

        return result;
    }
}

