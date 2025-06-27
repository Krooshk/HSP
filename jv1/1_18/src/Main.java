import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;

public class Main {
    private Random random = new Random();
    Logger logger = Logger.getLogger(getClass().getName());
    // Задание 1
    public static void operationWithMaps(){
        HashMap<Integer, String> map = new HashMap<>();

        int[] array = getRandomArray();
        int[] array2 = getRandomArray();

        for (int i = 0; i < 100; i++){
            map.put(array[i], String.valueOf(array2[i]));
        }

        for (HashMapEntry<Integer, String> entry : map.entrySet()) {
            String value = entry.getValue();
            logger.info(value);
        }

        map.clear();
    }

    public static int[] getRandomArray() {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++){
            array[i] = i + 1;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length - 1; j++) {
                boolean willSwap = this.random.nextInt(2) == 0;

                if (willSwap) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }

        return array;
    }

    // Задание 2
    public static ArrayList<Integer> getNumsMoreThen(ArrayList<Integer> list, int N) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : list) {
            if (map.containsKey(num)) {
                int old = map.get(num);
                map.put(num, old + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (HashMapEntry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue() == N) {
                result.add(entry.getKey());
            }
        }

        map.clear();

        return result;
    }

    public static void main(String[] args) {
        // Вызов для задания 1
        operationWithMaps();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            Random rand = new Random();
            int num = rand.nextInt(10) + 1;
            list.add(num);
        }

        // Получение списка из задания 2
        ArrayList<Integer> res = getNumsMoreThen(list, 12);
        for (Integer val : res) {
            logger.info(val);
        }
    }
}