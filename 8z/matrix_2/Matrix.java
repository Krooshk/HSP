import java.util.*;

public class Matrix
{
    final Char EMPTY_BIT = '0';
    final Char FULL_BIT = '1';
    public static String digital_rain(String col){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        Integer max = null;
        Integer left = null;
        Integer right = null;

        int currentBalance = 0;

        for (int i = 0; i < col.length(); i++){
            if (col.charAt(i) == FULL_BIT){
                currentBalance++;
            }
            if (col.charAt(i) == EMPTY_BIT){
                currentBalance--;
            }

            if (map.get(currentBalance) == null){
                map.put(currentBalance, i + 1);
            }
            int currLeft = map.get(currentBalance);
            int diff = i + 1 - currLeft;
            if (max == null || diff >= max) {
                max = diff;
                left = currLeft;
                right = i + 1;
            }
        }

        if (max == null) {
            return "";
        }

        return col.substring(left, right);
    }
}