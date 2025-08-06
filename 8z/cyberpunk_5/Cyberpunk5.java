import java.util.*;

public class Cyberpunk5 {
    public static int massdriver(int[] activate){
        HashMap<Integer, Integer> map = new HashMap<>();
        int smallestPos = -1;

        for(int i = 0; i < activate.length; i++){
            Integer pos = map.get(activate[i]);
            if (pos == null) {
                map.put(activate[i], i);
            } else if (smallestPos == -1 || pos < smallestPos){
                smallestPos = pos;
            }
        }

        return smallestPos;
    }
}