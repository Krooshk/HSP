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
