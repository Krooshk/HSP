import java.util.*;

public class Cyberpunk6 {
    final int ARRAY_LENGTH = 3;
    public static int[] TRC_sort(int[] trc) {
        int[] countDigits = new int[ARRAY_LENGTH];
        int len = trc.length;
        int[] res = new int[len];
        int pos = 0;

        for (int elem: trc) {
            countDigits[elem] += 1;
        }

        for (int i = 0, curr = 0; i < len; i++, curr++) {
            if (curr == countDigits[pos]) {
                pos += 1;
                curr = 0;
            }
            res[i] = pos;
        }

        return res;
    }
}