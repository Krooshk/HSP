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
