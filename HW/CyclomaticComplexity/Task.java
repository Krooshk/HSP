import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//    BigMinusRightOrder 175% изначально
    public static String BigMinusRightOrder(String s1, String s2){
        String result = "";

        int len1 = s1.length();
        int len2 = s2.length();
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];

        for (int u = 0; u < len1; u++){
            arr1[u] = getNum(s1, u);
        }

        for (int j = 0; j < len2; j++){
            arr2[j] = getNum(s2, j);
        }

        int debt = 0;
        for (int i = 0; i < len1; i++) {
            int secondElem = 0;
            if (len2 - 1 - i >= 0) secondElem = arr2[len2 - 1 - i];
            int diff = arr1[len1 - 1 - i] - secondElem - debt;
            if (diff >= 0) {
                arr1[len1 - 1 - i] = diff;
                debt = 0;
            } else {
                arr1[len1 - 1 - i] = diff + 10;
                debt = 1;
            }
        }

        boolean write = false;
        for (int k = 0; k < len1; k++){
            if (arr1[k] != 0) {
                write = true;
            }
            if (write) {
                result += arr1[k];
            }
        }

        if (result.length() == 0) {
            result = "0";
        }

        return result;
    }


//   BigMinusRightOrder 75% после рефакторинга
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


