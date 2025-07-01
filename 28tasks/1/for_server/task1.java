import java.util.*;

public class Level1
{
    public static int squirrel(int N)
    {
        double factorial = getFactorial(N);
        double rank = 1;

        for (double i = 1.0; factorial / i > 1.0; i *= 10.0) {
            rank = i;
        }

        double doubleRes = factorial / (rank);

        return (int) doubleRes;
    }

    public static double getFactorial(int N)
    {
        if (N == 0) return 1.0;
        double res = 1.0;
        for (int i = 1; i <= N; i++){
            res *= i;
        }

        return res;
    }
}


