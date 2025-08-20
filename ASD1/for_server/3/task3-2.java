import java.lang.reflect.Array;

// Здесь просто добавляю счетчик для счета и при дешевых операций добавляю разницу (3 - 1) в копилку, при реалокации вычитаю за каждую операцию 1.
// 3-6 DynArrayBank
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

import java.lang.reflect.Array;
import java.util.Arrays;

// 3-7 MultiDimensionalArray
// Здесь сложность была в том, когда передавать MultiDimensionalArray.class, а когда класс при инициализации (Integer).
// clazz всегда хранит Integer и по цепочке вниз он всегда передается, чтобы в итоге создать конечный массив, а если это промежуточный уровень, то тогда просто присваиваем полю.
// Здесь используется рекурсия , внутри класса вызываем тот же класс, если не конечный уровень.
// В JS используют spread и rest оператор в тандеме, в Java, как я узнал, если ожидаются аргументы и тип данных varargs можно просто передать массив.

public class MultiDimensionalArray<T> {
    public Object array;
    private int capacity;
    boolean isLast;
    int dimension;
    Class clazz;

    public MultiDimensionalArray(Class clz, int dimension, int size) {
        clazz = clz;
        this.isLast = dimension == 1;
        this.capacity = Math.max(16, size);
        this.dimension = dimension;
        makeArray(dimension, size);
    }

    public void makeArray(int dimension, int size)
    {
        if (this.isLast) {
            this.array = Array.newInstance(clazz, size);
        } else {
            this.array = Array.newInstance(MultiDimensionalArray.class, size);

            for (int i = 0; i < size; i++) {
                Array.set(array, i, new MultiDimensionalArray<>(clazz, dimension - 1, size));
            }
        }
        this.capacity = size;
    }

    public T get(int... indices) {
        if (indices.length != dimension) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int firstArg = indices[0];

        if (firstArg >= capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (this.isLast) {
            return ((T[]) array)[firstArg];
        } else {
            MultiDimensionalArray<T> nextLevel = ((MultiDimensionalArray<T>[]) array)[firstArg];
            return nextLevel.get(Arrays.copyOfRange(indices, 1, indices.length));
        }
    }

    private void extend(int requiredIndex, int dimension) {
        if (requiredIndex < capacity) return;

        int newCapacity = capacity;
        for (; newCapacity <= requiredIndex; newCapacity *= 2);

        if (this.isLast) {
            T[] newArray = (T[]) Array.newInstance(clazz, newCapacity);
            System.arraycopy(array, 0, newArray, 0, capacity);
            this.array = newArray;
        } else {
            MultiDimensionalArray<T>[] newArray =
                    (MultiDimensionalArray<T>[]) Array.newInstance(MultiDimensionalArray.class, newCapacity);
            System.arraycopy(array, 0, newArray, 0, capacity);

            for (int i = capacity; i < newCapacity; i++) {
                newArray[i] = new MultiDimensionalArray<>(clazz,
                        this.dimension - 1,
                        capacity);
            }
            this.array = newArray;
        }

        this.capacity = newCapacity;
    }

    public void set(T value, int... indices) {
        int firstArg = indices[0];

        extend(firstArg, indices.length);

        if (this.isLast) {
            ((T[]) array)[firstArg] = value;
        } else {
            MultiDimensionalArray<T>[] childArray = (MultiDimensionalArray<T>[]) array;
            MultiDimensionalArray<T> nextLevel = childArray[firstArg];

            nextLevel.set(value, Arrays.copyOfRange(indices, 1, indices.length));
        }
    }
}
