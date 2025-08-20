import java.lang.reflect.Array;
import java.util.Arrays;

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