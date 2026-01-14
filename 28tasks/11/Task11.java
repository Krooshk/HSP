import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task11
{
    public static String BigMinus(String s1, String s2){
        boolean isS1Biggest = isFirstBiggest(s1, s2);

        // Определяем наибольшую из строк, чтобы получить результат по модулю
        if (isS1Biggest) {
            return BigMinusRightOrder(s1, s2);
        } else {
            return BigMinusRightOrder(s2, s1);
        }

    }

    public static String BigMinusRightOrder(String s1, String s2){
        String result = "0";

        int len1 = s1.length();
        int len2 = s2.length();
        int[] arr1 = IntStream.range(0, len1)
                .map(i -> getNum(s1, i))
                .toArray();
        int[] arr2 = IntStream.range(0, len2)
                .map(i -> getNum(s2, i))
                .toArray();

        int debt = 0;
        for (int i = 0; i < len1; i++) {
            int secondElem = 0;
            if (len2 - 1 - i >= 0) secondElem = arr2[len2 - 1 - i];
            int diff = arr1[len1 - 1 - i] - secondElem - debt;
            if (diff >= 0) {
                arr1[len1 - 1 - i] = diff;
                debt = 0;
                continue;
            }
            arr1[len1 - 1 - i] = diff + 10;
            debt = 1;
        }

        result += Arrays.stream(arr1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));

        if (result.length() == 0) {
            result = "0";
            return result;
        }

        return result.replaceFirst("^0+", "");
    }

    public static int getNum(String s, int pos) {
        return Character.getNumericValue(s.charAt(pos));
    }

    public static  boolean isFirstBiggest(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return true;
        }

        for ( int i = 0; i < s1.length(); i++){
            int intFirst = getNum(s1, i);
            int intSecond = getNum(s2,i);
            if (intFirst > intSecond) {
                return true;
            }
        }

        return false;
    }
}

