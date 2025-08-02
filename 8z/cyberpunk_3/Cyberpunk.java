import java.util.*;

public class Cyberpunk
{
    public static boolean EEC_help(int [] arr1, int [] arr2){
        if (arr1.length != arr2.length) return false;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr1.length; i++){
            int elem = arr1[i];
            Integer count = map.get(elem);
            if (count != null) {
                map.put(elem, count + 1);
            } else {
                map.put(elem, 1);
            }
        }

        for (int j = 0; j < arr2.length; j++){
            int elem = arr2[j];
            Integer count = map.get(elem);
            if (count == null) {
                return false;
            }
            if (count == 1) {
                map.remove(elem);
            } else {
                map.put(elem, count - 1);
            }
        }

        return map.size() == 0;
    }
}