import java.util.*;

// 6-5 DequeMin
public class DequeMin<T>
{
    private LinkedList<Integer> _store;
    private Deque<Integer> minDeque;
    public DequeMin()
    {
        _store = new LinkedList();
        minDeque = new Deque<Integer>();
    }

    public void addFront(Integer item)
    {
        boolean isEmptyDeque = minDeque.size() == 0;
        _store.addFirst(item);

        for (;!isEmptyDeque && minDeque.peekFirst() > item;) {
            minDeque.removeFront();
        }
        minDeque.addFront(item);
    }

    public void addTail(Integer item)
    {
        boolean isEmptyDeque = minDeque.size() == 0;
        _store.addLast(item);

        for (;!isEmptyDeque && minDeque.peekTail() > item;) {
            minDeque.removeTail();
        }
        minDeque.addTail(item);
    }

    public Integer removeFront()
    {
        if (size() == 0) {
            return null;
        }

        Integer removedElement = (Integer) _store.removeFirst();
        if (minDeque.peekFirst() == removedElement) {
            minDeque.removeFront();
        }

        return removedElement;
    }

    public Integer removeTail()
    {
        if (size() == 0) {
            return null;
        }

        Integer removedElement = (Integer) _store.removeLast();
        if (minDeque.peekTail() == removedElement) {
            minDeque.removeTail();
        }

        return removedElement;
    }

    public Integer getMin(){
        if (size() == 0) return null;
        Integer minLeft = minDeque.peekFirst();
        Integer minRight = minDeque.peekTail();
        return minRight <= minLeft ? minRight: minLeft;
    }


    public int size()
    {
        return _store.size();
    }
}

