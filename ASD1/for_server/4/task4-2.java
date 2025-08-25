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

// 4-3 Если стек пустой, то цикл не запустится. Если его размер больше или равен 1, то будет выполняться пока не очистится полностью.

public class Additional {
    // 4-4 parenthesesValidator time - O(n) space - O(n)
    public static boolean parenthesesValidator(String str) {
        Stack<Character> stack = new Stack();
        for (char ch: str.toCharArray()){
            if (ch == '(') {
                stack.push('(');
            } else if (stack.pop() == null) {
                return false;
            }
        }

        return stack.size() == 0;
    }

    // 4-5 parenthesesValidatorV2 time - O(n) space - O(n)
    public static boolean parenthesesValidatorV2(String str) {
        Stack<Character> stack = new Stack();
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        set.add('(');
        set.add('[');
        set.add('{');
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char ch: str.toCharArray()){
            if (set.contains(ch)) {
                stack.push(ch);
            } else if (stack.pop() != map.get(ch)) {
                return false;
            }
        }

        return stack.size() == 0;
    }
}

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

// 4-8 postfixCount
public class Postfix {

    private Postfix(){}

    public static Integer postfixCount(String str) {
        Stack<String> s1 = new Stack<String>();
        Stack<String> s2 = new Stack<String>();
        String[] arr = str.split(" ");
        HashSet<String> operations = new HashSet<String>(Arrays.asList("+", "-", "*"));

        for (int i = arr.length - 1; i >= 0; i--){
            s1.push(arr[i]);
        }

        for (String curr = s1.pop(); curr != null; curr = s1.pop()){
            if (curr.equals("=")) {
                return Integer.valueOf(s2.pop());
            }
            if (operations.contains(curr)) {
                operation(curr, s2);
                continue;
            }

            Integer numericValue = Integer.valueOf(curr);
            s2.push(String.valueOf(numericValue));
        }

        return null;
    }

    public static void operation(String str, Stack<String> stack) {
        Integer operand1 = Integer.valueOf(stack.pop());
        Integer operand2 = Integer.valueOf(stack.pop());
        switch (str) {
            case "*":
                stack.push(String.valueOf(operand1 * operand2));
                break;
            case "+":
                stack.push(String.valueOf(operand1 + operand2));
                break;
            case "-":
                stack.push(String.valueOf(operand1 - operand2));
                break;
            default:
                break;
        }
    }


}


