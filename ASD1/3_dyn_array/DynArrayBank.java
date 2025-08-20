import java.lang.reflect.Array;

// Здесь просто добавляю счетчик для счета и при дешевых операций добавляю разницу (3 - 1) в копилку, при реалокации вычитаю за каждую операцию 1.

public class DynArrayBank<T> {
    public T [] array;
    public int count;
    public int capacity;
    public int bank = 0;
    Class clazz;

    public DynArrayBank(Class clz)
    {
        clazz = clz;
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);

        capacity = new_capacity;
        if (array != null) {
            System.arraycopy(array, 0, newArray, 0, count);
            bank -= count;
        }

        array = newArray;
    }

    public T getItem(int index)
    {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    public void append(T itm)
    {
        bank += 2;
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        array[count++] = itm;
    }

    // 3-3 insert time-O(n), space-O(n)
    public void insert(T itm, int index)
    {
        if (index < 0 || index > capacity - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        bank += 2;

        if (count == capacity) {
            makeArray(capacity * 2);
        }

        for (int i = count - 1; i >= index; i--) {
            array[i+1] = array[i];
            bank += 2;
        }
        array[index] = itm;
        count++;
    }

    // 3-4 insert time-O(n), space-O(1)
    public void remove(int index)
    {
        if (index < 0 || index >= capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int i = index + 1; i >= count; i++) {
            array[i-1] = array[i];
            bank += 2;
        }
        count--;

        if ((count * 1.0 /capacity) < 0.5) {
            int newCapacity = capacity * 2 / 3;
            int minimalCapacity = 16;
            int finalCapacity = newCapacity < minimalCapacity ? minimalCapacity : newCapacity;
            makeArray(finalCapacity);
        }
    }
}
