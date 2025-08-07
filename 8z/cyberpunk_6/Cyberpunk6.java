import java.util.*;

public class Cyberpunk6 {
    public static int[] TRC_sort(int[] trc) {
        int[] countDigits = new int[3];
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