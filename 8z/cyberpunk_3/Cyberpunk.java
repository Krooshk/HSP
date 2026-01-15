import java.util.*;

public class Cyberpunk
{
    public static boolean EEC_help(int [] arr1, int [] arr2){
        if (arr1.length != arr2.length) return false;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            int elem = arr1[i];
            Optional<Integer> count = Optional.ofNullable(map.get(elem));
            count.ifPresentOrElse(num -> map.put(elem, num + 1), () -> map.put(elem, 1));
        }

        for (int j = 0; j < arr2.length; j++) {
            int elem = arr2[j];
            Optional<Integer> count = Optional.ofNullable(map.get(elem));
            count.ifPresent(num -> {
                map.put(elem, num - 1);
                if (num == 1) map.remove(elem);
            });
        }

        return map.size() == 0;
    }
}