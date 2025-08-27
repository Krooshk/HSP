import java.util.*;

// 5-1 Queue
public class Queue<T>{
    private LinkedList<T>  _store;
    public Queue()
    {
        _store = new LinkedList<T>();
    }

    // 5-2 enqueue space-O(1) time-O(1)
    public void enqueue(T item)
    {
        _store.addLast(item);
    }

    // 5-2 dequeue space-O(1) time-O(1)
    public T dequeue()
    {
        if (size() == 0) {
            return null;
        }
        return _store.removeFirst();
    }

    public int size()
    {
        return _store.size();
    }

}

