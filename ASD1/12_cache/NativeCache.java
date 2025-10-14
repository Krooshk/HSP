import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.IntStream;

class NativeCache<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;

    public NativeCache(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        hits = new int[size];
        values = (T[]) Array.newInstance(clazz, this.size);

    }

    public int hashFun(String value)
    {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += (int) value.charAt(i);
        }
        int resultHashFun = sum % size;

        int index = resultHashFun;
        if (slots[index] == null || slots[index].equals(value)) {
            return index;
        }

        OptionalInt freeSlot = IntStream.range(0, size)
                .map(i -> (resultHashFun + i) % size)
                .filter(i -> slots[i] == null)
                .findFirst();

        return freeSlot.orElse(-1);
    }

    public boolean isKey(String key)
    {
        return key != null &&
                IntStream.range(0, slots.length)
                        .anyMatch(i -> key.equals(slots[i]));
    }

    public int getIndex(String key) {
        if (key == null) return -1;

        return IntStream.range(0, slots.length)
                .filter(i -> key.equals(slots[i]))
                .findFirst()
                .orElse(-1);
    }

    public int findMinIndex() {
        return IntStream.range(0, hits.length)
                .boxed()
                .min(Comparator.comparingInt(i -> hits[i]))
                .orElse(-1);
    }

    public void put(String key, T value)
    {
        int indexExist = getIndex(key);
        if (isKey(key) && indexExist >= 0) {
            hits[indexExist] += 1;
            values[indexExist] = value;
            return;
        }

        int index = hashFun(key);
        if (index >=0){
            slots[index] = key;
            values[index] = value;
            hits[index] = 1;
        } else {
            int swapIndex = findMinIndex();
            slots[swapIndex] = key;
            values[swapIndex] = value;
            hits[swapIndex] = 1;
        }
    }
}

