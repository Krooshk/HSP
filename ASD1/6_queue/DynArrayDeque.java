import java.lang.reflect.Array;

// 6 - 6 DynArrayDeque
public class DynArrayDeque<T> {
    public T [] array;
    public int count;
    public int capacity;
    Integer head;
    Integer tail;
    Class clazz;

    public DynArrayDeque(Class clz)
    {
        clazz = clz;
        count = 0;
        makeArray(16);
        head = null;
        tail = null;
    }


    public void makeArray(int new_capacity)
    {
        T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);
        capacity = new_capacity;
        if (array != null) {
            System.arraycopy(array, 0, newArray, 0, count);
        }

        array = newArray;
    }

    public void addTail(T item){
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        if (head == null) {
            int index = 0;
            array[index] = item;
            head = index;
            tail = index;
        }
        if (tail == capacity) {
            array[0] = item;
            tail = 0;
        } else {
            array[++tail] = item;
        }
        count++;
    }

    public void addFront(T item){
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        if (head == null) {
            int index = 0;
            array[index] = item;
            head = index;
            tail = index;
        }
        if (head == 0) {
            array[capacity - 1] = item;
            tail = capacity - 1;
        } else {
            array[--head] = item;
        }
        count++;

    }

    public T removeTail(T itm){
        if (count == 0) return null;
        if (tail == 0) {
            T elem = array[tail];
            array[tail] = null;
            tail = capacity - 1;
            return elem;
        }
        return array[tail--];
    }

    public T removeFront(T itm){
        if (count == 0) return null;
        if (head == capacity - 1) {
            T elem = array[head];
            array[head] = null;
            head = 0;
            return elem;
        }
        return array[head++];
    }

}
