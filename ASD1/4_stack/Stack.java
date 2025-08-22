import java.util.*;

// 4-1
public class Stack<T>
{
    private LinkedList<T> _store;
    public Stack()
    {
        _store = new LinkedList<>();
    }

    public int size()
    {
        return _store.size();
    }

    // time - O(1), space - O(1)
    public T pop()
    {
        if (size() == 0) {
            return null;
        }
        return _store.removeLast();
    }

    // time - O(1), space - O(1)
    public void push(T val)
    {
        _store.addLast(val);
    }

    public T peek()
    {
        if (size() == 0) {
            return null;
        }
        return _store.peekLast();
    }
}

// 4-2
class Stack2<T>
{
    private LinkedList<T> _store;
    public Stack2()
    {
        _store = new LinkedList<>();
    }

    public int size()
    {
        return _store.size();
    }

    // time - O(1), space - O(1)
    public T pop()
    {
        if (size() == 0) {
            return null;
        }
        return _store.removeFirst();
    }

    // time - O(1), space - O(1)
    public void push(T val)
    {
        _store.addFirst(val);
    }

    public T peek()
    {
        if (size() == 0) {
            return null;
        }
        return _store.peekFirst();
    }
}