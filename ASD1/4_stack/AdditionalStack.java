import java.util.LinkedList;

// 4-6, 4-7 minValue, average
public class AdditionalStack {
        private Stack<Integer> minStack;
        private LinkedList store;
        private int average = 0;
        public AdditionalStack()
        {
            store = new LinkedList<Integer>();
            minStack = new Stack<Integer>();

        }

        public Integer size()
        {
            return store.size();
        }

        public Integer pop()
        {
            if (size() == 0) {
                return null;
            }

            Integer removedElement = (Integer) store.removeLast();
            if (minStack.peek() == removedElement) {
                minStack.pop();
            }
            average -= removedElement;
            return removedElement;
        }

        public void push(int val)
        {
            boolean isEmptyMinStack = minStack.size() == 0;
            Integer minElem = minStack.peek();
            if (isEmptyMinStack || minElem >= val) {
                minStack.push(val);
            }
            average +=  val;
            store.addLast(val);
        }

        public Integer peek()
        {
            if (size() == 0) {
                return null;
            }
            return (Integer) store.peekLast();
        }

        public Integer getMin(){
            return minStack.peek();
        }

        public Integer getAverage(){
            return (int) average / this.size();
        }
}
