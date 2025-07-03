import java.util.*;

public class Task6
{
    public static String PatternUnlock(int N, int [] hits) {
        double diag = Math.sqrt(2);
        int prev = hits[0];
        double res = 0;

        for (int i = 1; i < hits.length; i++) {
            if (Math.abs(hits[i] - prev) == 3 || Math.abs(hits[i] - prev) == 1) {
                res += 1.0;
            } else if (Math.abs(hits[i] - prev) == 8 || (prev + hits[i] == 10) && Math.abs(hits[i] - prev) == 4) {
                res += 2 * diag;
            } else {
                res += diag;
            }
            prev = hits[i];
        }

        return removeZero(String.format("%.5f", res));
    };

    public static String removeZero(String str){
        String res = "";

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch != '0' && ch != '.'){
                res += ch;
            }
        }

        return res;
    };

}


