import java.util.*;

public class Level1
{
    public static String PatternUnlock(int N, int [] hits) {
        HashMap<Integer, Integer[]> oneHit = new HashMap<>();
        oneHit.put(1, new Integer[]{ 2, 6, 9});
        oneHit.put(2, new Integer[]{ 1, 5, 3, 8});
        oneHit.put(3, new Integer[]{ 2, 4, 7});
        oneHit.put(4, new Integer[]{ 5, 3 });
        oneHit.put(5, new Integer[]{ 6, 2, 4} );
        oneHit.put(6, new Integer[]{ 1, 5 });
        oneHit.put(7, new Integer[]{ 3, 8 });
        oneHit.put(8, new Integer[]{ 2, 7, 9});
        oneHit.put(9, new Integer[]{ 1, 8 });

        double diag = Math.sqrt(2);
        int prev = hits[0];
        double res = 0;

        for (int i = 1; i < hits.length; i++) {
            Integer[] neighbours = oneHit.get(hits[i]);
            List<Integer> list = Arrays.asList(neighbours);
            if (list.contains(prev)) {
                res += 1.0;
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



