import java.lang.reflect.Array;
import java.util.Arrays;

abstract class DynArray<T> {
    public static final int APPEND_NIL = 0;
    public static final int APPEND_OK = 1;
  
    private final int INSERT_STATUS_NIL = 0;
    private final int INSERT_STATUS_OK = 1;
    private final int INSERT_STATUS_ERR = 2;
  
    private final int REMOVE_STATUS_NIL = 0;
    private final int REMOVE_STATUS_OK = 1;
    private final int REMOVE_STATUS_ERR = 2;
  
    private final int GET_STATUS_NIL = 0;
    private final int GET_STATUS_OK = 1;
    private final int GET_STATUS_ERR = 2;

    // постусловие: создан пустой массив
    protected DynArray(Class<T> clz) {}

    // ** команды **
    // предусловие: 0 <= index <= size()
    // постусловие: на позицию index вставлен элемент, остальные сдвинуты вправо
    public abstract void insert(int index, T value);

    // постусловие: в хвост массива добавлен новый элемент
    public abstract void append(T value);

    // предусловие: 0 <= i < size()
    // постусловие: элемент под индексом i удалён, остальные сдвинуты влево
    public abstract void remove(int i);

    // ** запросы **
    // предусловие: 0 <= i < size()
    public abstract T get(int i);
    public abstract int size();

    // ** запросы статусов **
    public abstract int get_insert_status();
    public abstract int get_append_status();
    public abstract int get_remove_status();
    public abstract int get_get_status();
}

class DynamicArrayImpl<T> extends DynArray<T> {
    private static final int    MIN_CAPACITY     = 16;
    private static final int    GROWTH_FACTOR    = 2;
    private static final double MIN_FULLNESS     = 0.5;
    private static final double REDUCTION_FACTOR = 1.5;

    private T[] array;
    private int count;
    private int capacity;
    private final Class<T> clazz;

    private int insert_status = INSERT_NIL;
    private int append_status = APPEND_NIL;
    private int remove_status = REMOVE_NIL;
    private int get_status    = GET_NIL;

    @SuppressWarnings("unchecked")
    private void makeArray(int newCapacity) {
        if (newCapacity < MIN_CAPACITY)
            newCapacity = MIN_CAPACITY;
        if (array == null)
            array = (T[]) Array.newInstance(clazz, newCapacity);
        else if (newCapacity != capacity)
            array = Arrays.copyOf(array, newCapacity);
        capacity = newCapacity;
    }

    public DynamicArrayImpl(Class<T> clazz) {
        super(clazz);
        this.clazz = clazz;
        this.count = 0;
        makeArray(MIN_CAPACITY);
    }

    @Override
    public void insert(int index, T value) {
        if (index < 0 || index > count) {
            insert_status = INSERT_ERR;
            return;
        }
        if (count == capacity)
            makeArray(capacity * GROWTH_FACTOR);
        for (int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        count++;
        insert_status = INSERT_OK;
    }

    @Override
    public void append(T value) {
        if (count == capacity)
            makeArray(capacity * GROWTH_FACTOR);
        array[count] = value;
        count++;
        append_status = APPEND_OK;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= count) {
            remove_status = REMOVE_ERR;
            return;
        }
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        array[count - 1] = null;
        count--;
        remove_status = REMOVE_OK;

        if (count < capacity * MIN_FULLNESS) {
            makeArray((int) (capacity / REDUCTION_FACTOR)); // не меньше MIN_CAPACITY, элементы помещаются
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= count) {
            get_status = GET_ERR;
            return null;
        }
        get_status = GET_OK;
        return array[index];
    }

    @Override
    public int size() { return count; }

    @Override
    public int get_insert_status() { return insert_status; }

    @Override
    public int get_append_status() { return append_status; }

    @Override
    public int get_remove_status() { return remove_status; }

    @Override
    public int get_get_status() { return get_status; }
}
