import java.util.*;

// 6-1 Deque
public class Deque<T>
{
    LinkedList<T> _store;
    public Deque()
    {
        _store = new LinkedList();
    }

    public void addFront(T item)
    {
        _store.addFirst(item);
    }

    public void addTail(T item)
    {
        _store.addLast(item);
    }

    public T removeFront()
    {
        if (size() == 0) {
            return null;
        }

        return _store.removeFirst();
    }

    public T removeTail()
    {
        if (size() == 0) {
            return null;
        }

        return _store.removeLast();
    }

    public int size()
    {
        return _store.size();
    }

    public T peekTail(){
        return _store.peekLast();
    }

    public T peekFirst(){
        return _store.peekFirst();
    }
}

