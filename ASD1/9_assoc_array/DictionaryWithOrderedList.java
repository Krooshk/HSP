import java.lang.reflect.Array;
import java.util.Arrays;

public class DictionaryWithOrderedList<T> {
    public int size;
    private Note<T>[] values;
    private int count;

    public DictionaryWithOrderedList(int sz)
    {
        size = sz;
        values = new Note[size];
        count = 0;
    }

    // put: time - O(log n), space - O(1)
    public void put(String key, T value)
    {
        if (count == size) return;

        Note note = new Note(key, value);
        if (count == 0) {
            values[0] = note;
            count++;
            return;
        }

        int insertPos = find(key);
        int index = insertPos;
        if (insertPos < 0) {
            index = -index - 1;
        };

        for (int j = count; j > index; j--) {
            values[j] = values[j - 1];
        }

        values[index] = note;
        count++;
    }

    // find: time - O(log n), space - O(1)
    public int find(String key) {
        int low = 0;
        int high = count - 1;

        for (;low <= high;) {
            int mid = (low + high) / 2;
            if (values[mid].key.equals(key)) {
                return mid;
            }

            if (values[mid].key.compareTo(key) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -(low + 1);
    }

    // delete: time - O(n), space - O(1)
    public void delete(String key) {
        int index = find(key);
        if (index < 0) {
            return;
        }

        for (int i = index; i < count; i++) {
            values[i] = values[i+1];
        }
        count--;
    }

    // get: time - O(log n), space - O(1)
    public T get(String key) {
        int index = find(key);
        if (index < 0) {
            return null;
        }
        return values[index].value;
    }

    public int getCount(){
        return count;
    }

    public String[] getKey(){
        return Arrays.stream(values, 0, count)
                .map(note -> note.key)
                .toArray(String[]::new);
    }
}

class Note<T> {
    String key;
    T value;

    Note(String key, T value) {
        this.key = key;
        this.value = value;
    }
}
