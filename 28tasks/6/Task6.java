import java.util.*;

public class Task6
{
    final static String FORMAT_PATTERN = "%.5f"; // 5 знаков в дробной части
    public static String PatternUnlock(int N, int [] hits) {
        HashMap<Integer, Integer[]> oneHit = new HashMap<>();
        // Для чисел заранее вычислены соседи на клавишах
        oneHit.put(1, new Integer[]{ 2, 6, 9});
        oneHit.put(2, new Integer[]{ 1, 5, 3, 8});
        oneHit.put(3, new Integer[]{ 2, 4, 7});
        oneHit.put(4, new Integer[]{ 5, 3 });
        oneHit.put(5, new Integer[]{ 6, 2, 4} );
        oneHit.put(6, new Integer[]{ 1, 5 });
        oneHit.put(7, new Integer[]{ 3, 8 });
        oneHit.put(8, new Integer[]{ 2, 7, 9});
        oneHit.put(9, new Integer[]{ 1, 8 });

        int prev = hits[0];
        double res = 0;

        for (int i = 1; i < N; i++) {
            Integer[] neighbours = oneHit.get(hits[i]);
            List<Integer> list = Arrays.asList(neighbours);
            if (list.contains(prev)) {
                res += 1.0;
            } else {
                res += Math.sqrt(2);
            }
            prev = hits[i];
        }

        return removeZero(String.format(FORMAT_PATTERN, res));
    };

    public static String removeZero(String str){
        String res = "";

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch != '0' && ch != '.' && ch != ',') {
                res += ch;
            }
        }

        return res;
    };

}


