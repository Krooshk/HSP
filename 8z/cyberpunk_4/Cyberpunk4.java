import java.util.*;

public class Cyberpunk4 {
    final int SIZE_FIBERS = 8192;
    public static int artificial_muscle_fibers(int[] arr){
        byte[] store = new byte[SIZE_FIBERS];

        for (int el: arr) {
            getStateOfNum(store, el);
        }

        return getResult(store);
    }

    public static void getStateOfNum(byte[] store, int num){

        int pos = num / 4;
        byte b = store[pos];
        int mod = num % 4;

        int firstPos = mod * 2;
        int secondPos = firstPos + 1;

        boolean hasFirstValue = getBit(b, firstPos);
        boolean hasSecondValue = getBit(b, secondPos);

        if (hasSecondValue) {
            return;
        }

        if (hasFirstValue) {
            b = setBit(b, secondPos);
            store[pos] = b;
            addOne(store);
            return;
        }

        b = setBit(b, firstPos);
        store[pos] = b;

        assert pos >= 0;
    }

    public static boolean getBit(byte b, int bitPosition) {
        return ((b >> bitPosition) & 1) != 0;
    }

    public static byte setBit(byte b, int bitPosition) {
        return (byte) (b | (1 << bitPosition));
    }

    public static void addOne(byte[] store) {
        store[8001] += 1;
        if (store[8001] == 0) {
            store[8002] += 1;
        }
    }

    public static int getResult(byte[] store){
        byte first = store[8001];
        byte second = store[8002];

        return ((second & 0xFF) << 8) | (first & 0xFF);
    }

}