import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test public void pushRegres(){
        Stack stack = new Stack<>();
        for (int i = 0; i < 4; i++){
            stack.push(i + 1);
        }

        assertEquals(stack.size(), 4);
        assertEquals(stack.peek(), 4);
        assertEquals(stack.size(), 4);
    }

    @Test public void popRegres(){
        Stack stack = new Stack<>();
        for (int i = 0; i < 4; i++){
            stack.push(i + 1);
        }
        for (int i = 0; i < 4; i++){
            stack.pop();
        }

        assertEquals(stack.size(), 0);
        assertEquals(stack.peek(), null);
        assertEquals(stack.pop(), null);
    }

    @Test public void peekRegres(){
        Stack stack = new Stack<>();
        for (int i = 0; i < 4; i++){
            stack.push(i + 1);
        }
        for (int i = 0; i < 2; i++){
            stack.pop();
        }

        assertEquals(stack.peek(), 2);
    }

    @Test public void sizeRegres(){
        Stack stack = new Stack<>();
        for (int i = 0; i < 4; i++){
            stack.push(i + 1);
        }
        assertEquals(stack.size(), 4);
    }

    @Test public void sizeRegres2(){
        Stack stack = new Stack<>();

        assertEquals(stack.size(), 0);
    }

    @Test public void pushDifferentType(){
        Stack stack = new Stack<>();
        stack.push(1);
        stack.push("2");
        stack.push(3.14);

        assertEquals(stack.size(), 3);
        assertEquals(stack.pop().getClass().getName(), "java.lang.Double");
        assertEquals(stack.pop().getClass().getName(), "java.lang.String");
        assertEquals(stack.pop().getClass().getName(), "java.lang.Integer");
    }
}