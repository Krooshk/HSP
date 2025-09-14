import java.lang.reflect.Array;

// 9-6*
public class ByteNativeDictionary<T> {
    public int size;
    public int btsize;
    public T[] values;

    public ByteNativeDictionary(int btsize, Class<T> clazz) {
        this.btsize = btsize;
        size = (int) Math.pow(2, btsize);
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFunc(String value) {
        if (value.length() != btsize) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(value, 2);
    }

    public void put(String key, T value) {
        int index = hashFunc(key);
        if (index >= 0 && index < size) {
            values[index] = value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void delete(String key) {
        int index = hashFunc(key);
        if (index >= 0 && index < size) {
            values[index] = null;
        }
    }

    public T get(String key) {
        int index = hashFunc(key);
        if (index >= 0 && index < size) {
            return values[index];
        }
        return null;
    }
}