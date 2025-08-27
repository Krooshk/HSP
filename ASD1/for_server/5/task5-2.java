public class AdditionalQueue<T> {
    // 5-3 round time-O(N) space-O(N)
    public Queue round(Queue<T> queue, int N) {
        int n = N >= queue.size() ? N % queue.size() : N;

        for (int i = 0; i < n; i++) {
            T elem = queue.dequeue();
            queue.enqueue(elem);
        }

        return queue;
    }

    // 5-5 reverse space-O(n) time-O(n)
    public Queue reverse(Queue<T> queue) {
        Stack<T> stack = new Stack<>();

        for(;queue.size()>0;) {
            T elem = queue.dequeue();
            stack.push(elem);
        }

        for(;stack.size()>0;) {
            T elem = stack.pop();
            queue.enqueue(elem);
        }

        return queue;
    }
}

public class QueueBasedOnTwoStack<T> {
    private Stack<T> myQueue;
    private Stack<T> stack;
    // 5-4 QueueBasedOnTwoStack time-O(N) space-O(N)
    QueueBasedOnTwoStack() {
        myQueue  = new Stack<>();
        stack  = new Stack<>();
    }

    // 5-4 time-O(N) space-O(N)
    public void enqueue(T item)
    {
        for (; myQueue.size() > 0;){
            T elem = myQueue.pop();
            stack.push(elem);
        }
        stack.push(item);
    }

    // 5-4 time-O(N) space-O(N)
    public T dequeue()
    {
        for (; stack.size() > 0;){
            T elem = stack.pop();
            myQueue.push(elem);
        }
        if (myQueue.size() == 0) {
            return null;
        }
        return myQueue.pop();
    }

    public int size()
    {
        return stack.size() + myQueue.size();
    }
}

// 5-6 BufferQueue
public class BufferQueue {
    int[] array;
    Integer start = null;
    Integer end = null;
    BufferQueue(int size){
        array = new int[size];
    }

    public void enqueue(int item)
    {
        if (isFull()) return;
        if (start == null) {
            array[0] = item;
            start = 0;
            end = 0;
            return;
        }
        if (end == array.length - 1 ) {
            array[0] = item;
            end = 0;
        } else {
            array[++end] = item;
        }
    }

    public Integer dequeue()
    {
        if (amount() == 0) {
            return null;
        }
        if (start == end) {
            int elem = array[start];
            end = null;
            start = null;
            return elem;
        }
        if (start == array.length -1) {
            int elem = array[start];
            start = 0;
            return elem;
        }

        return array[start++];
    }

    public boolean isFull(){

        return amount() == array.length;
    }

    public int amount()
    {
        if (start == null) return 0;
        return end >= start ? (end - start + 1) : (end + 1 + array.length - start);
    }
}





