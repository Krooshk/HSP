import java.util.LinkedList;

public class AdditionalStackWithMin<T extends Comparable<T>> {
        private Stack<T> minStack;
        private LinkedList<T> store;
        public AdditionalStackWithMin()
        {
            store = new LinkedList<>();
            minStack = new Stack<>();
        }

        public int size()
        {
            return store.size();
        }

        public T pop()
        {
            if (size() == 0) {
                return null;
            }

            T removedElement = store.removeLast();
            if (minStack.peek() == removedElement) {
                minStack.pop();
            }
            return removedElement;
        }

        public void push(T val)
        {
            boolean isEmptyMinStack = minStack.size() == 0;
            T minElem = minStack.peek();
            if (isEmptyMinStack || minElem.compareTo(val) >= 0) {
                minStack.push(val);
            }
            store.addLast(val);
        }

        public T peek()
        {
            if (size() == 0) {
                return null;
            }
            return store.peekLast();
        }

        public T getMin(){
            return minStack.peek();
        }
}
