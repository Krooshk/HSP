import java.util.*;

public class Task13
{
    public static int[] UFO(int N, int [] data, boolean octal) {
        int[] copy = Arrays.copyOf(data, N);
        int base;
        if (octal) {
            base = 8;
        } else {
            base = 16;
        }

        for (int i = 0; i < N; i++) {
            copy[i] = transformToSystem(data[i], base);
        }

        return copy;
    }

    public static int transformToSystem(int num, int base) {
        int result = 0;
        String strNum = String.valueOf(num);
        String[] digitsStr = strNum.split("");
        int len = digitsStr.length;
        int[] digits = new int[len];

        for (int i = 0; i < len; i++) {
            digits[i] = Integer.parseInt(digitsStr[i]);
        }

        int degree = 0;

        for (int j = 0; j < len; j++){
            result += (int) Math.pow(base, degree) * digits[len - 1 - j];
            degree++;
        }

        return result;
    }

}

